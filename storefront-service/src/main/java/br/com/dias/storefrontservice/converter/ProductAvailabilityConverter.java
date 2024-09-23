package br.com.dias.storefrontservice.converter;

import br.com.dias.storefrontservice.entity.ProductDataEntity;
import br.com.dias.storefrontservice.model.inbound.response.ProductAvailability;
import org.mapstruct.Mapper;

@Mapper
public interface ProductAvailabilityConverter {
    ProductAvailability convert(ProductDataEntity productDataEntity);
}
