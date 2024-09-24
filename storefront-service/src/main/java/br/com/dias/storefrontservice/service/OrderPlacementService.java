package br.com.dias.storefrontservice.service;

import br.com.dias.storefrontservice.model.inbound.messaging.OrderProcessed;
import br.com.dias.storefrontservice.model.inbound.request.OrderPlacementRequest;
import br.com.dias.storefrontservice.model.inbound.response.OrderPlacementResponse;

public interface OrderPlacementService {
    OrderPlacementResponse placeOrder(OrderPlacementRequest orderPlacementRequest);

    void exportOrders();

    void concludeProcessing(OrderProcessed orderProcessed);
}
