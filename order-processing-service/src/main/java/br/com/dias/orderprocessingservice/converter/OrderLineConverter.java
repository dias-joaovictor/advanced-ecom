package br.com.dias.orderprocessingservice.converter;

import br.com.dias.commons.messaging.OrderLine;
import br.com.dias.orderprocessingservice.entity.OrderLineEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OrderLineConverter {
    OrderLineEntity convert(OrderLine orderLine);
}
