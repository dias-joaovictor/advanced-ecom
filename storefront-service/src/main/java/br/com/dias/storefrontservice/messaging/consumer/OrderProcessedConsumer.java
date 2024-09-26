package br.com.dias.storefrontservice.messaging.consumer;

import br.com.dias.commons.messaging.OrderProcessed;
import br.com.dias.storefrontservice.service.OrderPlacementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderProcessedConsumer implements Consumer<OrderProcessed> {

    private final OrderPlacementService orderPlacementService;

    @Override
    public void accept(OrderProcessed orderProcessed) {
        log.info("Order has been processed successfully: {}", orderProcessed);
        orderPlacementService.concludeProcessing(orderProcessed);
    }
}
