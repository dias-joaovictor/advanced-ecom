package br.com.dias.storefrontservice.converter;

import br.com.dias.storefrontservice.entity.OrderLineEntity;
import br.com.dias.storefrontservice.model.inbound.request.OrderLinesRequest;
import br.com.dias.storefrontservice.model.messaging.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderLineConverter {
    @Mapping(target = "price", source = "priceOverride")
    OrderLineEntity convert(OrderLinesRequest orderLinesRequest);

    OrderLine convert(OrderLineEntity orderLine);
}
