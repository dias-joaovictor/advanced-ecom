package br.com.dias.storefrontservice.converter;

import br.com.dias.storefrontservice.entity.ProductData;
import br.com.dias.storefrontservice.model.inbound.messaging.ProductDataFeed;
import org.mapstruct.Mapper;

@Mapper
public interface ProductDataFeedConverter {
    ProductData convert(ProductDataFeed productDataFeed);
}
