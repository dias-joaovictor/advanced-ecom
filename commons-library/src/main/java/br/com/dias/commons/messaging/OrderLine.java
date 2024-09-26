package br.com.dias.commons.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderLine {
    private UUID id;

    private String sku;

    private BigDecimal price;

    private BigDecimal totalPrice;

    private int quantity;

}
