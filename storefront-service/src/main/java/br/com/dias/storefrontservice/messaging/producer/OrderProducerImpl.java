package br.com.dias.storefrontservice.messaging.producer;

import br.com.dias.storefrontservice.model.messaging.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducerImpl implements OrderProducer {

    @Value("${spring.cloud.stream.bindings.orderProducer-out-0.destination}")
    private String topicName;

    private final StreamBridge streamBridge;

    @Override
    public void produce(Order order) {
        streamBridge.send(topicName, order);
    }
}
