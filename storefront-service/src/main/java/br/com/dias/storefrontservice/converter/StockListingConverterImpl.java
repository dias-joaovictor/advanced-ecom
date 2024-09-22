package br.com.dias.storefrontservice.converter;

import br.com.dias.storefrontservice.entity.ProductData;
import br.com.dias.storefrontservice.model.inbound.response.StockListing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StockListingConverterImpl implements StockListingConverter {

    private final ProductAvailabilityConverter productAvailabilityConverter;

    @Override
    public StockListing convert(List<ProductData> productDataList) {
        return StockListing.builder()
                .stock(productDataList.stream().map(productAvailabilityConverter::convert).toList())
                .build();
    }
}
