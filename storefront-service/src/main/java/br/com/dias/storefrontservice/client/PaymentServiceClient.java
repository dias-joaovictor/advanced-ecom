package br.com.dias.storefrontservice.client;

import br.com.dias.storefrontservice.model.outbound.request.HoldPaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
@FeignClient("payment-service")
public interface PaymentServiceClient {

    @PostMapping(value = "/payments/hold")
    void holdPayment(@RequestBody HoldPaymentRequest holdPaymentRequest);

    @PutMapping("/payments/charge/{orderId}")
    void chargePayment(@PathVariable UUID orderId);
}
