package br.com.dias.orderprocessingservice.model.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class OrderProcessed {
    private UUID orderId;
}
