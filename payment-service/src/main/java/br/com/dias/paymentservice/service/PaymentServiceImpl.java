package br.com.dias.paymentservice.service;

import br.com.dias.paymentservice.converter.PaymentConverter;
import br.com.dias.paymentservice.entity.PaymentStatus;
import br.com.dias.paymentservice.exception.PaymentNotFoundException;
import br.com.dias.paymentservice.model.inbound.request.HoldPaymentRequest;
import br.com.dias.paymentservice.repository.PaymentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentConverter paymentConverter;

    private final PaymentRepository paymentRepository;

    @Override
    public void holdPayment(@Valid @NotNull HoldPaymentRequest holdPaymentRequest) {
        if (paymentRepository.getPaymentEntityByOrderId(holdPaymentRequest.getOrderId()).isPresent()) {
            log.info("Order already has payment {}", holdPaymentRequest.getOrderId());
            return;
        }
        var entity = paymentConverter.convert(holdPaymentRequest);
        entity.setStatus(PaymentStatus.HOLD);
        paymentRepository.save(entity);
    }

    @Override
    public void chargePayment(@Valid @NotNull UUID orderId) {
        paymentRepository.getPaymentEntityByOrderId(orderId)
                .ifPresentOrElse(
                        item -> {
                            item.setStatus(PaymentStatus.CHARGED);
                            paymentRepository.save(item);
                        },
                        () -> {
                            throw new PaymentNotFoundException(orderId);
                        }
                );
    }
}
