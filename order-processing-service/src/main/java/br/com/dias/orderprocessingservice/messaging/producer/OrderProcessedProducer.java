package br.com.dias.orderprocessingservice.messaging.producer;

import br.com.dias.orderprocessingservice.model.messaging.OrderProcessed;

public interface OrderProcessedProducer {
    void produce(OrderProcessed orderProcessed);
}
