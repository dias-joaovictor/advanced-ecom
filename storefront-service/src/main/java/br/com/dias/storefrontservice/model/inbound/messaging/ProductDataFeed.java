package br.com.dias.storefrontservice.model.inbound.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@SuperBuilder
@AllArgsConstructor
@Data
public class ProductDataFeed {

    private UUID id;

    private String sku;

    private String description;

    private BigDecimal price;

    private boolean enabled;

    private int quantity;

}
