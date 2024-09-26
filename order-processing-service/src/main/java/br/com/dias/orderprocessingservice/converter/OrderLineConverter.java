package br.com.dias.orderprocessingservice.converter;

import br.com.dias.orderprocessingservice.entity.OrderLineEntity;
import br.com.dias.orderprocessingservice.model.messaging.OrderLine;
import org.mapstruct.Mapper;

@Mapper
public interface OrderLineConverter {
    OrderLineEntity convert(OrderLine orderLine);
}
