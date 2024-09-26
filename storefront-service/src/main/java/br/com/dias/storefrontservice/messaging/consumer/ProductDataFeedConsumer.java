package br.com.dias.storefrontservice.messaging.consumer;

import br.com.dias.commons.messaging.ProductDataFeed;
import br.com.dias.storefrontservice.service.ProductDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductDataFeedConsumer implements Consumer<ProductDataFeed> {

    private final ProductDataService productDataService;

    @Override
    public void accept(ProductDataFeed productDataFeed) {
        log.info("Processing product data feed: {}", productDataFeed);
        productDataService.process(productDataFeed);
    }
}
