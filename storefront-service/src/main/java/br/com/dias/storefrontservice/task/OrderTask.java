package br.com.dias.storefrontservice.task;

import br.com.dias.storefrontservice.service.OrderPlacementService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderTask {

    private final OrderPlacementService orderPlacementService;
    
    @Scheduled(cron = "${tasks.order-placement.cron-expression}")
    public void exportOrders() {
        orderPlacementService.exportOrders();
    }
}
