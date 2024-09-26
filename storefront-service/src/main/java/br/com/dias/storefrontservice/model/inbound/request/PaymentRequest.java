package br.com.dias.storefrontservice.model.inbound.request;

import br.com.dias.storefrontservice.model.EcommerceRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PaymentRequest implements EcommerceRequest {

    @NotNull
    @NotBlank
    @Size(min = 30, max = 30, message = "Payment Provider Hash is invalid")
    private String paymentProviderHash;
}
