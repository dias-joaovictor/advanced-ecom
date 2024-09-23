package br.com.dias.customerservice.model.inbound.request;

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
public class CustomerRequest implements EcommerceRequest {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50, message = "The firstName must be between 1 and 50 characters long.")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100, message = "The lastName must be between 1 and 100 characters long.")
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50, message = "The lastName must be between 1 and 50 characters long.")
    private String email;

    @NotNull
    private AddressRequest address;
}
