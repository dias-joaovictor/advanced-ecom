package br.com.dias.productfeedservice.messaging.producer;

import br.com.dias.productfeedservice.model.outbound.ProductDataFeed;

public interface ProductDataProducer {

    void produce(ProductDataFeed productDataFeed);

}
