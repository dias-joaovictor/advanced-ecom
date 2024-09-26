package br.com.dias.paymentservice.controller;

import br.com.dias.paymentservice.model.inbound.request.HoldPaymentRequest;
import br.com.dias.paymentservice.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentEndpoint {

    private final PaymentService paymentService;

    @PostMapping("/hold")
    public void holdPayment(@Valid @NotNull @RequestBody HoldPaymentRequest holdPaymentRequest) {
        paymentService.holdPayment(holdPaymentRequest);
    }

    @PutMapping("/charge/{orderId}")
    public void chargePayment(@Valid @NotNull @PathVariable UUID orderId) {
        paymentService.chargePayment(orderId);
    }

}
