package br.com.dias.productfeedservice.messaging.producer;

import br.com.dias.productfeedservice.model.messaging.ProductDataFeed;

public interface ProductDataProducer {

    void produce(ProductDataFeed productDataFeed);

}
