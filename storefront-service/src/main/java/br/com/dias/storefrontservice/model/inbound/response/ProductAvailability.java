package br.com.dias.storefrontservice.model.inbound.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductAvailability {

    private String sku;

    private String description;

    private BigDecimal price;

    private int quantity;
}
