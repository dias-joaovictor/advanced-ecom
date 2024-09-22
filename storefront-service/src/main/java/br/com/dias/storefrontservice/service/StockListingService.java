package br.com.dias.storefrontservice.service;

import br.com.dias.storefrontservice.model.inbound.response.StockListing;

public interface StockListingService {
    StockListing getStockListing(String sku);
}
