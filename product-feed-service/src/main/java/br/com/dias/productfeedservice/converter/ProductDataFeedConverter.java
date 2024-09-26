package br.com.dias.productfeedservice.converter;

import br.com.dias.commons.messaging.ProductDataFeed;
import br.com.dias.productfeedservice.entity.ProductDataEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductDataFeedConverter {
    ProductDataFeed convert(ProductDataEntity productDataEntity);
}
