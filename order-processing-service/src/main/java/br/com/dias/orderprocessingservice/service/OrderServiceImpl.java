package br.com.dias.orderprocessingservice.service;

import br.com.dias.orderprocessingservice.converter.OrderConverter;
import br.com.dias.orderprocessingservice.entity.Status;
import br.com.dias.orderprocessingservice.messaging.producer.OrderProcessedProducer;
import br.com.dias.orderprocessingservice.model.messaging.Order;
import br.com.dias.orderprocessingservice.model.messaging.OrderProcessed;
import br.com.dias.orderprocessingservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static br.com.dias.orderprocessingservice.entity.Status.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderConverter orderConverter;
    private final OrderRepository orderRepository;
    private final OrderProcessedProducer orderProcessedProducer;

    @Override
    @Transactional
    public void process(Order order) {
        var orderEntity = orderConverter.convert(order);

        if (orderRepository.existsById(orderEntity.getId())) {
            log.info("Order with id {} already exists", orderEntity.getId());
            return;
        }

        orderEntity.setOrderStatus(Status.PLACED);
        orderRepository.save(orderEntity);
    }

    @Override
    public void updateOrderStatus() {
        orderRepository.findAllByOrderStatusNot(DISPATCHED)
                .forEach(order -> {
                    Status nextStatus = getNextStatus(order.getOrderStatus());
                    order.setOrderStatus(nextStatus);
                    orderRepository.save(order);
                    if (nextStatus == DISPATCHED) {
                        orderProcessedProducer.produce(OrderProcessed.builder()
                                .orderId(order.getId())
                                .build());
                    }
                });
    }

    private Status getNextStatus(Status status) {
        return switch (status) {
            case PLACED -> PAYMENT_AUTHORIZED;
            case PAYMENT_AUTHORIZED -> PROCESSING;
            case PROCESSING -> DISPATCHED;
            default -> null;
        };
    }
}
