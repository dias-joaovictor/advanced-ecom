package br.com.dias.storefrontservice.model.outbound.response;

import br.com.dias.storefrontservice.model.EcommerceResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerOutboundResponse implements EcommerceResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private AddressOutboundResponse address;
}
