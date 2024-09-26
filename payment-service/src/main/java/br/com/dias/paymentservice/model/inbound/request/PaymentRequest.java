package br.com.dias.paymentservice.model.inbound.request;

import br.com.dias.paymentservice.model.EcommerceRequest;
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
public class PaymentRequest implements EcommerceRequest {
    private UUID orderId;

    private BigDecimal amount;
}
