package br.com.dias.productfeedservice.service;

import br.com.dias.productfeedservice.converter.ProductDataFeedConverter;
import br.com.dias.productfeedservice.entity.ProductDataEntity;
import br.com.dias.productfeedservice.messaging.producer.ProductDataProducer;
import br.com.dias.productfeedservice.repository.ProductDataRepository;
import jakarta.annotation.PostConstruct;
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

    private static final BigDecimal TEN = new BigDecimal(10);
    private static final BigDecimal HUNDRED = new BigDecimal(100);
    private static final BigDecimal TWENTY_FIVE = new BigDecimal(25);
    private final ProductDataRepository productDataRepository;

    private final ProductDataProducer productDataProducer;

    private final ProductDataFeedConverter productDataFeedConverter;

    private final Random random = new Random();

    @PostConstruct
    public void init() {
        fullProductExport();
    }

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

    private void fakeUpdatePrice(ProductDataEntity productDataEntity) {
        log.info("Updating price for {}", productDataEntity);
        productDataEntity.setEnabled(random.nextBoolean());

        if (productDataEntity.isEnabled()) {
            BigDecimal priceChangeFactor = BigDecimal.ONE.add(new BigDecimal(random.nextBoolean() ? 1 : -1)
                    .multiply(new BigDecimal(random.nextInt(41))
                            .add(TEN))
                    .divide(HUNDRED, new MathContext(2)));

            var newPrice = productDataEntity.getPrice().multiply(priceChangeFactor);
            if (newPrice.compareTo(TWENTY_FIVE) < 0) {
                newPrice = TWENTY_FIVE;
            }
            productDataEntity.setPrice(newPrice);
            productDataEntity.setQuantity(random.nextInt(100));
        }

    }

}
