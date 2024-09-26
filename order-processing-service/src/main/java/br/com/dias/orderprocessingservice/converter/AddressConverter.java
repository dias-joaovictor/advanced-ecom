package br.com.dias.orderprocessingservice.converter;

import br.com.dias.commons.messaging.ShippingAddress;
import br.com.dias.orderprocessingservice.entity.ShippingAddressEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AddressConverter {
    ShippingAddressEntity convert(ShippingAddress shippingAddress);
}
