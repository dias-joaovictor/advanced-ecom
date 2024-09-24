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
public class AddressRequest implements EcommerceRequest {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100, message = "The street must be between 1 and 100 characters long.")
    private String street;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100, message = "The city must be between 1 and 100 characters long.")
    private String city;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100, message = "The state must be between 1 and 50 characters long.")
    private String state;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100, message = "The postalCode must be between 1 and 10 characters long.")
    private String postalCode;
}
