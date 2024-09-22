package br.com.dias.storefrontservice.converter;

import br.com.dias.storefrontservice.entity.ProductData;
import br.com.dias.storefrontservice.model.inbound.response.StockListing;

import java.util.List;

public interface StockListingConverter {
    StockListing convert(List<ProductData> productDataList);
}
