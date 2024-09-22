package br.com.dias.storefrontservice.controller;

import br.com.dias.storefrontservice.model.inbound.response.StockListing;
import br.com.dias.storefrontservice.service.StockListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-listing")
@RequiredArgsConstructor
public class ProductEndpoint {

    private final StockListingService stockListingService;

    @GetMapping
    public StockListing getStockListing() {
        return stockListingService.getStockListing(null);
    }

    @GetMapping("/by-sku/{sku}")
    public StockListing getStockListing(@PathVariable String sku) {
        return stockListingService.getStockListing(sku);
    }
}
