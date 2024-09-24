package br.com.dias.storefrontservice.client;

import br.com.dias.storefrontservice.model.outbound.response.CustomerOutboundResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Component
@FeignClient("CUSTOMER-SERVICE")
public interface CustomerServiceClient {

    @GetMapping("/customers/{id}")
    CustomerOutboundResponse findById(@PathVariable @Valid @NotNull UUID id);
}
