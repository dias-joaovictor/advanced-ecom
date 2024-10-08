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
public class AddressOutboundResponse implements EcommerceResponse {

    private UUID id;

    private String street;

    private String city;

    private String state;

    private String postalCode;
}
