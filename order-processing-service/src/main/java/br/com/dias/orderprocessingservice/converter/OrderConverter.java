package br.com.dias.orderprocessingservice.converter;

import br.com.dias.orderprocessingservice.entity.OrderEntity;
import br.com.dias.orderprocessingservice.model.messaging.Order;
import org.mapstruct.Mapper;

@Mapper(uses = {AddressConverter.class, OrderLineConverter.class})
public interface OrderConverter {
    OrderEntity convert(Order order);
}
