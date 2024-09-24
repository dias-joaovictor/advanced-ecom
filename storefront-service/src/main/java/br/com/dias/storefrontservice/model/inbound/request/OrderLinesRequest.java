package br.com.dias.storefrontservice.model.inbound.request;

import br.com.dias.storefrontservice.model.EcommerceRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderLinesRequest implements EcommerceRequest {

    @NotNull
    @NotEmpty
    @Size(min = 13, max = 13, message = "The sku must be 13 characters long.")
    private String sku;

    private BigDecimal priceOverride;

    @Min(1)
    private int quantity;

}
