package br.com.dias.storefrontservice.model.inbound.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StockListing {
    private List<ProductAvailability> stock;
}
