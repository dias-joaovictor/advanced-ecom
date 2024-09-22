package br.com.dias.productfeedservice.service;

import br.com.dias.productfeedservice.converter.ProductDataFeedConverter;
import br.com.dias.productfeedservice.entity.ProductData;
import br.com.dias.productfeedservice.messaging.producer.ProductDataProducer;
import br.com.dias.productfeedservice.repository.ProductDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductDataServiceImpl implements ProductDataService {

    public static final BigDecimal TEN = new BigDecimal(10);
    public static final BigDecimal HUNDRED = new BigDecimal(100);
    private final ProductDataRepository productDataRepository;

    private final ProductDataProducer productDataProducer;

    private final ProductDataFeedConverter productDataFeedConverter;

    private final Random random = new Random();

    @Override
    public void fakeProductUpdate() {
        productDataRepository.findAll()
                .stream()
                .filter(item -> shouldUpdate())
                .peek(this::fakeUpdatePrice)
                .map(item -> {
                    productDataRepository.save(item);
                    return productDataFeedConverter.convert(item);
                })
                .forEach(productDataProducer::produce);
    }

    @Override
    public void fullProductExport() {
        productDataRepository.findAll()
                .stream()
                .map(productDataFeedConverter::convert)
                .forEach(productDataProducer::produce);
    }

    private boolean shouldUpdate() {
        return random.nextBoolean();
    }

    private void fakeUpdatePrice(ProductData productData) {
        log.info("Updating price for {}", productData);
        productData.setEnabled(random.nextBoolean());

        if (productData.isEnabled()) {
            BigDecimal priceChangeFactor = BigDecimal.ONE.add(new BigDecimal(random.nextBoolean() ? 1 : -1)
                    .multiply(new BigDecimal(random.nextInt(41))
                            .add(TEN))
                    .divide(HUNDRED, new MathContext(2)));

            var newPrice = productData.getPrice().multiply(priceChangeFactor);
            productData.setPrice(newPrice);
            productData.setQuantity(random.nextInt(100));
        }

    }

}
