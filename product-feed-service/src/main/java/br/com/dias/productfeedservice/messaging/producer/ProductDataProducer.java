package br.com.dias.productfeedservice.messaging.producer;


import br.com.dias.commons.messaging.ProductDataFeed;

public interface ProductDataProducer {

    void produce(ProductDataFeed productDataFeed);

}
