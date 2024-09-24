package br.com.dias.storefrontservice.converter;

import br.com.dias.storefrontservice.entity.ShippingAddressEntity;
import br.com.dias.storefrontservice.model.inbound.request.AddressRequest;
import br.com.dias.storefrontservice.model.outbound.response.AddressOutboundResponse;
import org.mapstruct.Mapper;

@Mapper
public interface AddressConverter {
    AddressRequest convert(AddressOutboundResponse addressOutboundResponse);

    ShippingAddressEntity convert(AddressRequest addressRequest);
}
