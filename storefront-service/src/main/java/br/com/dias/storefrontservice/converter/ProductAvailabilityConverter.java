package br.com.dias.storefrontservice.converter;

import br.com.dias.storefrontservice.entity.ProductData;
import br.com.dias.storefrontservice.model.inbound.messaging.ProductDataFeed;
import br.com.dias.storefrontservice.model.inbound.response.ProductAvailability;
import org.mapstruct.Mapper;

@Mapper
public interface ProductAvailabilityConverter {
    ProductAvailability convert(ProductData productData);
}
