package br.com.dias.storefrontservice.service;

import br.com.dias.storefrontservice.converter.StockListingConverter;
import br.com.dias.storefrontservice.entity.ProductDataEntity;
import br.com.dias.storefrontservice.model.inbound.response.StockListing;
import br.com.dias.storefrontservice.repository.ProductDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockListingServiceImpl implements StockListingService {

    private final StockListingConverter stockListingConverter;

    private final ProductDataRepository productDataRepository;

    public StockListing getStockListing(String sku) {

        List<ProductDataEntity> products = sku == null
                ? productDataRepository.findAllByEnabledIsTrue()
                : productDataRepository.findAllByEnabledIsTrueAndSkuEquals(sku);

        return stockListingConverter.convert(products);
    }
}
