package br.com.dias.storefrontservice.model.inbound.response;

import br.com.dias.storefrontservice.model.inbound.EcommerceResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StockListing implements EcommerceResponse {
    private List<ProductAvailability> stock;
}
