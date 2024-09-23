package br.com.dias.customerservice.service;

import br.com.dias.customerservice.model.inbound.request.CustomerRequest;
import br.com.dias.customerservice.model.inbound.response.CustomerResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface CustomerService {

    CustomerResponse create(@Valid @NotNull CustomerRequest customerRequest);

    CustomerResponse findById(@Valid @NotNull UUID id);

    CustomerResponse update(@Valid @NotNull UUID id, @Valid @NotNull CustomerRequest customerRequest);

    void delete(@Valid @NotNull UUID id);
}
