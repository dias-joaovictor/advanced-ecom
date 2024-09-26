package br.com.dias.customerservice.model.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShippingAddress {
    private UUID id;

    private String street;

    private String city;

    private String state;

    private String postalCode;
}
