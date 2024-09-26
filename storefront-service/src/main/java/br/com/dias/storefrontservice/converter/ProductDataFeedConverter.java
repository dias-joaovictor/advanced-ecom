package br.com.dias.storefrontservice.converter;

import br.com.dias.commons.messaging.ProductDataFeed;
import br.com.dias.storefrontservice.entity.ProductDataEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductDataFeedConverter {
    ProductDataEntity convert(ProductDataFeed productDataFeed);
}
