package br.com.dias.storefrontservice.service;

import br.com.dias.commons.messaging.ProductDataFeed;
import br.com.dias.storefrontservice.entity.ProductDataEntity;

import java.util.List;
import java.util.Set;

public interface ProductDataService {
    void process(ProductDataFeed productDataFeed);

    List<ProductDataEntity> getProductsBySku(Set<String> skus);
}
