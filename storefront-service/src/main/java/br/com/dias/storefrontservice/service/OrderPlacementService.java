package br.com.dias.storefrontservice.service;

import br.com.dias.storefrontservice.model.inbound.request.OrderPlacementRequest;
import br.com.dias.storefrontservice.model.inbound.response.OrderPlacementResponse;

public interface OrderPlacementService {
    OrderPlacementResponse placeOrder(OrderPlacementRequest orderPlacementRequest);
}
