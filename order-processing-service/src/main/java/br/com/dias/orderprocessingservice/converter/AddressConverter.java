package br.com.dias.orderprocessingservice.converter;

import br.com.dias.orderprocessingservice.entity.ShippingAddressEntity;
import br.com.dias.orderprocessingservice.model.messaging.ShippingAddress;
import org.mapstruct.Mapper;

@Mapper
public interface AddressConverter {
    ShippingAddressEntity convert(ShippingAddress shippingAddress);
}
