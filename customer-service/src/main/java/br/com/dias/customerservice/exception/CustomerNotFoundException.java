package br.com.dias.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
    private static final String CUSTOMER_NOT_FOUND = "Customer %s not found";

    public CustomerNotFoundException(UUID id) {
        super(CUSTOMER_NOT_FOUND.formatted(id));
    }

}
