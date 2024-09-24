package br.com.dias.storefrontservice.messaging.producer;

import br.com.dias.storefrontservice.model.outbound.messaging.Order;

public interface OrderProducer {
    void produce(Order order);
}
