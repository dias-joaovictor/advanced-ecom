package br.com.dias.orderprocessingservice.messaging.producer;

import br.com.dias.commons.messaging.OrderProcessed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProcessedProducerImpl implements OrderProcessedProducer {

    @Value("${spring.cloud.stream.bindings.orderProcessedProducer-out-0.destination}")
    private String topicName;

    private final StreamBridge streamBridge;

    @Override
    public void produce(OrderProcessed orderProcessed) {
        streamBridge.send(topicName, orderProcessed);
    }
}
