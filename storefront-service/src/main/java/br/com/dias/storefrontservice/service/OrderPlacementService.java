package br.com.dias.storefrontservice.service;

import br.com.dias.storefrontservice.model.inbound.request.OrderPlacementRequest;
import br.com.dias.storefrontservice.model.inbound.response.OrderPlacementResponse;
import br.com.dias.storefrontservice.model.messaging.OrderProcessed;

public interface OrderPlacementService {
    OrderPlacementResponse placeOrder(OrderPlacementRequest orderPlacementRequest);

    void exportOrders();

    void concludeProcessing(OrderProcessed orderProcessed);
}
