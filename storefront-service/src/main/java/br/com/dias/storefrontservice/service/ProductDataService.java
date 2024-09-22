package br.com.dias.storefrontservice.service;

import br.com.dias.storefrontservice.model.inbound.messaging.ProductDataFeed;

public interface ProductDataService {
    void process(ProductDataFeed productDataFeed);
}
