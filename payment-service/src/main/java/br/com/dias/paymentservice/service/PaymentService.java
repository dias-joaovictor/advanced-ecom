package br.com.dias.paymentservice.service;

import br.com.dias.paymentservice.model.inbound.request.HoldPaymentRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface PaymentService {

    void holdPayment(@Valid @NotNull HoldPaymentRequest holdPaymentRequest);

    void chargePayment(@Valid @NotNull UUID orderId);
}
