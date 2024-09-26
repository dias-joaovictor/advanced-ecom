package br.com.dias.paymentservice.converter;

import br.com.dias.paymentservice.entity.PaymentEntity;
import br.com.dias.paymentservice.model.inbound.request.HoldPaymentRequest;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentConverter {
    PaymentEntity convert(HoldPaymentRequest holdPaymentRequest);
}
