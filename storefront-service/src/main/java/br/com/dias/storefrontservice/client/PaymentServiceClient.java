package br.com.dias.storefrontservice.client;

import br.com.dias.storefrontservice.model.outbound.request.HoldPaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@Component
@FeignClient("PAYMENT-SERVICE")
public interface PaymentServiceClient {

    @PostMapping("/payments/hold")
    void holdPayment(HoldPaymentRequest holdPaymentRequest);

    @PutMapping("/payments/charge/{orderId}")
    void chargePayment(UUID orderId);
}
