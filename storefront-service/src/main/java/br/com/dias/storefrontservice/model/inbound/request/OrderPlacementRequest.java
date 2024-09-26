package br.com.dias.storefrontservice.model.inbound.request;

import br.com.dias.storefrontservice.model.EcommerceRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderPlacementRequest implements EcommerceRequest {

    @NotNull
    private UUID customerId;

    @NotNull
    @NotEmpty
    private List<OrderLinesRequest> orderLines;

    private AddressRequest shippingAddress;

    private boolean shippingAddressIsCustomersAddress;

    private PaymentRequest payment;
}
