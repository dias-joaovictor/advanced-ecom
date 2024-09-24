package br.com.dias.storefrontservice.model.inbound.response;

import br.com.dias.storefrontservice.model.inbound.EcommerceResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductAvailability implements EcommerceResponse {

    private String sku;

    private String description;

    private BigDecimal price;

    private int quantity;
}
