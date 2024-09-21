package br.com.dias.productfeedservice.messaging.producer;

import br.com.dias.productfeedservice.model.outbound.ProductDataFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDataProducerImpl implements ProductDataProducer {

    @Value("${spring.cloud.stream.bindings.productDataFeed-out-0.destination}")
    private String topicName;

    private final StreamBridge streamBridge;

    @Override
    public void produce(ProductDataFeed productDataFeed) {
        streamBridge.send(topicName, productDataFeed);
    }
}
