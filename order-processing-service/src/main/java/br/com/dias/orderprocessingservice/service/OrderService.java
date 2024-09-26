package br.com.dias.orderprocessingservice.service;

import br.com.dias.commons.messaging.Order;

public interface OrderService {
    void process(Order order);

    void updateOrderStatus();
}
