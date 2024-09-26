package br.com.dias.orderprocessingservice.task;

import br.com.dias.orderprocessingservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderUpdate {
    private final OrderService orderService;

    @Scheduled(cron = "${tasks.order-status-update.cron-expression}")
    public void updateStates() {
        orderService.updateOrderStatus();
    }

}
