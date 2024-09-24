package br.com.dias.storefrontservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    private static final String PRODUCT_NOT_FOUND = "Product(s) not found %s";

    public ProductNotFoundException(List<String> skus) {
        super(PRODUCT_NOT_FOUND.formatted(skus));
    }
}
