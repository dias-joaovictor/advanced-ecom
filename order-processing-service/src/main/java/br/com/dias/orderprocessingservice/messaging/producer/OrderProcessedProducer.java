package br.com.dias.orderprocessingservice.messaging.producer;

import br.com.dias.commons.messaging.OrderProcessed;

public interface OrderProcessedProducer {
    void produce(OrderProcessed orderProcessed);
}
