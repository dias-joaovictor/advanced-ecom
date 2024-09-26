package br.com.dias.storefrontservice.converter;

import br.com.dias.storefrontservice.entity.OrderEntity;
import br.com.dias.storefrontservice.model.inbound.request.OrderPlacementRequest;
import br.com.dias.storefrontservice.model.messaging.Order;
import org.mapstruct.Mapper;

@Mapper(uses = {AddressConverter.class, OrderLineConverter.class})
public interface OrderConverter {
    OrderEntity convert(OrderPlacementRequest orderPlacementRequest);

    Order convert(OrderEntity orderEntity);
}
