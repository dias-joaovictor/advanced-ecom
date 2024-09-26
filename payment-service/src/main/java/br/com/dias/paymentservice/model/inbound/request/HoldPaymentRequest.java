package br.com.dias.paymentservice.model.inbound.request;

import br.com.dias.paymentservice.model.EcommerceRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString(of = {"orderId"})
public class HoldPaymentRequest implements EcommerceRequest {

    @NotNull(message = "OrderId cannot be null")
    private UUID orderId;

    @NotNull
    @NotBlank
    @Size(min = 50, max = 50, message = "Payment Provider Hash is invalid")
    private String paymentProviderHash;

    @NotNull
    @Min(1)
    private BigDecimal amount;
}
