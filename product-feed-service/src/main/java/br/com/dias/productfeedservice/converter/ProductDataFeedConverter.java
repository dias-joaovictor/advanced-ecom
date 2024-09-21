package br.com.dias.productfeedservice.converter;

import br.com.dias.productfeedservice.entity.ProductData;
import br.com.dias.productfeedservice.model.outbound.ProductDataFeed;
import org.mapstruct.Mapper;

@Mapper
public interface ProductDataFeedConverter {
    ProductDataFeed convert(ProductData productData);
}
