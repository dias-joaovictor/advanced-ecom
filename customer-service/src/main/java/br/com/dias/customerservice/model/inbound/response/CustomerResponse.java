package br.com.dias.customerservice.model.inbound.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerResponse implements EcommerceResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private AddressResponse address;
}
