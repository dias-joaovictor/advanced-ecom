package br.com.dias.orderprocessingservice.messaging.consumer;

import br.com.dias.orderprocessingservice.model.messaging.Order;
import br.com.dias.orderprocessingservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class OrderConsumer implements Consumer<Order> {

    private final OrderService orderService;

    @Override
    public void accept(Order order) {
        orderService.process(order);
    }
}
