package br.com.dias.commons.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {

    private UUID id;

    private UUID customerId;

    private List<OrderLine> orderLines;

    private ShippingAddress shippingAddress;

    private BigDecimal amount;
}
