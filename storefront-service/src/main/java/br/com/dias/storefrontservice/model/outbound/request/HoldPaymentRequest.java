package br.com.dias.storefrontservice.model.outbound.request;

import br.com.dias.storefrontservice.model.EcommerceRequest;
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
public class HoldPaymentRequest implements EcommerceRequest {

    private UUID orderId;

    private String paymentProviderHash;

    private BigDecimal amount;
}
