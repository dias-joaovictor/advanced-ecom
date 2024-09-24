package br.com.dias.storefrontservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {
    private static final String ORDER_NOT_FOUND = "Order not found %s";

    public OrderNotFoundException(String orderId) {
        super(ORDER_NOT_FOUND.formatted(orderId));
    }
}
