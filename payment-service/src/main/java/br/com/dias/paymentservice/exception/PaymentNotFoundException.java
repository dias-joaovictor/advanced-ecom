package br.com.dias.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Payment not found for order %s";

    public PaymentNotFoundException(UUID orderId) {
        super(MESSAGE.formatted(orderId.toString()));
    }
}
