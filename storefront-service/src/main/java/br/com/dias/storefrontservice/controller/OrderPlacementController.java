package br.com.dias.storefrontservice.controller;

import br.com.dias.storefrontservice.model.inbound.request.OrderPlacementRequest;
import br.com.dias.storefrontservice.model.inbound.response.OrderPlacementResponse;
import br.com.dias.storefrontservice.service.OrderPlacementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-placement")
@RequiredArgsConstructor
@Tag(name = "Order Placement")
public class OrderPlacementController {

    private final OrderPlacementService orderPlacementService;

    @PostMapping
    @Operation(summary = "Placement of an order")
    public OrderPlacementResponse placeOrder(@Valid @NotNull @RequestBody OrderPlacementRequest orderPlacementRequest) {
        return orderPlacementService.placeOrder(orderPlacementRequest);
    }

}
