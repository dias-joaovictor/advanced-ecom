package br.com.dias.storefrontservice.service;

import br.com.dias.storefrontservice.converter.ProductDataFeedConverter;
import br.com.dias.storefrontservice.model.inbound.ProductDataFeed;
import br.com.dias.storefrontservice.repository.ProductDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDataServiceImpl implements ProductDataService {

    private final ProductDataFeedConverter productDataFeedConverter;

    private final ProductDataRepository productDataRepository;

    @Override
    public void process(ProductDataFeed productDataFeed) {
        productDataRepository.save(productDataFeedConverter.convert(productDataFeed));
    }
}
