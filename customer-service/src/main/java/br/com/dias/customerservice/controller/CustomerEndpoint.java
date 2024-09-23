package br.com.dias.customerservice.controller;

import br.com.dias.customerservice.model.inbound.request.CustomerRequest;
import br.com.dias.customerservice.model.inbound.response.CustomerResponse;
import br.com.dias.customerservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Tag(name = "Customers Management", description = "Operations related to Customers")
public class CustomerEndpoint {

    private final CustomerService customerService;

    @PostMapping
    @Operation(summary = "Create customer")
    public CustomerResponse create(@RequestBody @Valid @NotNull CustomerRequest customerRequest) {
        return customerService.create(customerRequest);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Customer")
    public CustomerResponse findById(@PathVariable @Valid @NotNull UUID id) {
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Customer")
    public CustomerResponse update(@PathVariable @Valid @NotNull UUID id,
                                   @RequestBody @Valid @NotNull CustomerRequest customerRequest) {
        return customerService.update(id, customerRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Customer")
    public void delete(@PathVariable @Valid @NotNull UUID id) {
        customerService.delete(id);
    }


}
