package br.com.dias.storefrontservice.messaging.producer;


import br.com.dias.commons.messaging.Order;

public interface OrderProducer {
    void produce(Order order);
}
