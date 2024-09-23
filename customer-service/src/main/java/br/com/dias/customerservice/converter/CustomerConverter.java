package br.com.dias.customerservice.converter;

import br.com.dias.customerservice.entity.CustomerEntity;
import br.com.dias.customerservice.model.inbound.request.CustomerRequest;
import br.com.dias.customerservice.model.inbound.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(uses = AddressConverter.class)
public interface CustomerConverter extends Converter<CustomerRequest, CustomerResponse, CustomerEntity> {
}
