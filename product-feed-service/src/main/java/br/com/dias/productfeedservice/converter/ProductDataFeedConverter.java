package br.com.dias.productfeedservice.converter;

import br.com.dias.productfeedservice.entity.ProductDataEntity;
import br.com.dias.productfeedservice.model.outbound.ProductDataFeed;
import org.mapstruct.Mapper;

@Mapper
public interface ProductDataFeedConverter {
    ProductDataFeed convert(ProductDataEntity productDataEntity);
}
