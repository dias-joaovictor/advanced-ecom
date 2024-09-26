package br.com.dias.storefrontservice.service;

import br.com.dias.commons.messaging.OrderProcessed;
import br.com.dias.storefrontservice.client.CustomerServiceClient;
import br.com.dias.storefrontservice.client.PaymentServiceClient;
import br.com.dias.storefrontservice.converter.AddressConverter;
import br.com.dias.storefrontservice.converter.OrderConverter;
import br.com.dias.storefrontservice.entity.ProductDataEntity;
import br.com.dias.storefrontservice.entity.Status;
import br.com.dias.storefrontservice.exception.OrderNotFoundException;
import br.com.dias.storefrontservice.messaging.producer.OrderProducer;
import br.com.dias.storefrontservice.model.inbound.request.OrderLinesRequest;
import br.com.dias.storefrontservice.model.inbound.request.OrderPlacementRequest;
import br.com.dias.storefrontservice.model.inbound.request.PaymentRequest;
import br.com.dias.storefrontservice.model.inbound.response.OrderPlacementResponse;
import br.com.dias.storefrontservice.model.outbound.request.HoldPaymentRequest;
import br.com.dias.storefrontservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderPlacementServiceImpl implements OrderPlacementService {

    private final CustomerServiceClient customerServiceClient;
    private final PaymentServiceClient paymentServiceClient;
    private final OrderRepository orderRepository;

    private final AddressConverter addressConverter;

    private final OrderConverter orderConverter;

    private final ProductDataService productDataService;

    private final Validator validator;

    private final OrderProducer orderProducer;

    @Override
    @Transactional
    public OrderPlacementResponse placeOrder(@Valid @NotNull OrderPlacementRequest orderPlacementRequest) {
        var customerData = customerServiceClient.findById(orderPlacementRequest.getCustomerId());
        if (orderPlacementRequest.isShippingAddressIsCustomersAddress()) {
            orderPlacementRequest.setShippingAddress(addressConverter.convert(customerData.getAddress()));
        } else {
            validator.validateObject(orderPlacementRequest.getShippingAddress());
        }

        Map<String, ProductDataEntity> products = productDataService.getProductsBySku(orderPlacementRequest
                        .getOrderLines()
                        .stream()
                        .map(OrderLinesRequest::getSku)
                        .collect(Collectors.toSet()))
                .stream()
                .collect(Collectors.toMap(ProductDataEntity::getSku, Function.identity()));

        orderPlacementRequest.getOrderLines().forEach(item -> {
            if (item.getPriceOverride() == null) {
                item.setPriceOverride(products.get(item.getSku()).getPrice());
            }
        });

        var order = orderConverter.convert(orderPlacementRequest);
        order.setAmount(new BigDecimal(0));
        order.getOrderLines()
                .forEach(orderLine -> {
                    orderLine.setTotalPrice(orderLine.getPrice()
                            .multiply(new BigDecimal(orderLine.getQuantity()))
                            .setScale(2, RoundingMode.HALF_UP));

                    order.setAmount(order.getAmount().add(orderLine.getTotalPrice()));
                    orderLine.setOrder(order);
                });
        order.setOrderStatus(Status.PLACED);
        orderRepository.save(order);

        paymentServiceClient.holdPayment(HoldPaymentRequest.builder()
                .orderId(order.getId())
                .amount(order.getAmount())
                .paymentProviderHash(Optional.ofNullable(orderPlacementRequest.getPayment())
                        .map(PaymentRequest::getPaymentProviderHash)
                        .orElse(null))
                .build());

        return OrderPlacementResponse.builder()
                .orderId(order.getId())
                .build();
    }

    @Override
    public void exportOrders() {
        this.orderRepository
                .findAllByOrderStatus(Status.PLACED)
                .stream()
                .map(item -> {
                    item.setOrderStatus(Status.PROCESSING);
                    orderRepository.save(item);
                    return orderConverter.convert(item);
                })
                .forEach(orderProducer::produce);
    }

    @Override
    @Transactional
    public void concludeProcessing(OrderProcessed orderProcessed) {
        orderRepository.findById(orderProcessed.getOrderId())
                .ifPresentOrElse(order -> {
                    order.setOrderStatus(Status.PROCESSED);
                    orderRepository.save(order);
                    paymentServiceClient.chargePayment(order.getId());
                }, () -> {
                    throw new OrderNotFoundException(orderProcessed.getOrderId().toString());
                });
    }

}
