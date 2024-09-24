package br.com.dias.storefrontservice.model.inbound.response;

import br.com.dias.storefrontservice.model.inbound.EcommerceResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderPlacementResponse implements EcommerceResponse {

    private UUID orderId;
}
