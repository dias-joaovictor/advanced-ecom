package br.com.dias.paymentservice.model.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class ProductDataFeed {

    private UUID id;

    private String sku;

    private String description;

    private BigDecimal price;

    private boolean enabled;

    private int quantity;

    private Instant updatedAt;
}

