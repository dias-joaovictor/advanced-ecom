package br.com.dias.orderprocessingservice.converter;

import br.com.dias.commons.messaging.Order;
import br.com.dias.orderprocessingservice.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {AddressConverter.class, OrderLineConverter.class})
public interface OrderConverter {
    OrderEntity convert(Order order);
}
