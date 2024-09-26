package br.com.dias.storefrontservice.converter;

import br.com.dias.storefrontservice.entity.ProductDataEntity;
import br.com.dias.storefrontservice.model.messaging.ProductDataFeed;
import org.mapstruct.Mapper;

@Mapper
public interface ProductDataFeedConverter {
    ProductDataEntity convert(ProductDataFeed productDataFeed);
}
