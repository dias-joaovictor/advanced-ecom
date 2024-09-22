package br.com.dias.storefrontservice.service;

import br.com.dias.storefrontservice.model.inbound.ProductDataFeed;

public interface ProductDataService {
    void process(ProductDataFeed productDataFeed);
}
