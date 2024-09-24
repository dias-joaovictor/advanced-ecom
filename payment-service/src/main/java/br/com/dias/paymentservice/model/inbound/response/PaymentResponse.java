package br.com.dias.paymentservice.model.inbound.response;

import br.com.dias.paymentservice.model.inbound.request.EcommerceRequest;
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
public class PaymentResponse implements EcommerceRequest {
    private UUID orderId;

    private UUID paymentId;

    private BigDecimal amount;
}
