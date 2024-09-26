package br.com.dias.storefrontservice.service;

import br.com.dias.storefrontservice.converter.ProductDataFeedConverter;
import br.com.dias.storefrontservice.entity.ProductDataEntity;
import br.com.dias.storefrontservice.exception.ProductNotFoundException;
import br.com.dias.storefrontservice.model.messaging.ProductDataFeed;
import br.com.dias.storefrontservice.repository.ProductDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductDataServiceImpl implements ProductDataService {

    private final ProductDataFeedConverter productDataFeedConverter;

    private final ProductDataRepository productDataRepository;

    @Override
    public void process(ProductDataFeed productDataFeed) {
        productDataRepository.save(productDataFeedConverter.convert(productDataFeed));
    }

    @Override
    public List<ProductDataEntity> getProductsBySku(Set<String> skus) {
        var products = productDataRepository.findAllByEnabledIsTrueAndSkuIn(skus);
        var productsSku = products.stream().map(ProductDataEntity::getSku).collect(Collectors.toSet());
        var itemsNotFound = new ArrayList<String>();


        skus.forEach(item -> {
            if (!productsSku.contains(item)) {
                itemsNotFound.add(item);
            }
        });

        if (!itemsNotFound.isEmpty()) {
            throw new ProductNotFoundException(itemsNotFound);
        }
        return products.stream().toList();
    }
}
