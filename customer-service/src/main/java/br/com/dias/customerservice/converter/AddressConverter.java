package br.com.dias.customerservice.converter;

import br.com.dias.customerservice.entity.AddressEntity;
import br.com.dias.customerservice.model.inbound.request.AddressRequest;
import br.com.dias.customerservice.model.inbound.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper
public interface AddressConverter extends Converter<AddressRequest, AddressResponse, AddressEntity> {
}
