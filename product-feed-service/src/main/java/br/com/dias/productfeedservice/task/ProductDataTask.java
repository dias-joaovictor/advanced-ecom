package br.com.dias.productfeedservice.task;

import br.com.dias.productfeedservice.service.ProductDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@RequiredArgsConstructor
public class ProductDataTask {
    private final ProductDataService productDataService;

    @Scheduled(cron = "${tasks.product-update.cron-expression}")
    public void updatePrices() {
        productDataService.fakeProductUpdate();
    }

    @Scheduled(cron = "${tasks.full-product-export.cron-expression}")
    public void fullProductExport() {
        productDataService.fullProductExport();
    }
}
