package br.com.dias.customerservice.service;

import br.com.dias.customerservice.converter.CustomerConverter;
import br.com.dias.customerservice.exception.CustomerNotFoundException;
import br.com.dias.customerservice.model.inbound.request.CustomerRequest;
import br.com.dias.customerservice.model.inbound.response.CustomerResponse;
import br.com.dias.customerservice.repository.CustomerRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    @Override
    public CustomerResponse create(@Valid @NotNull CustomerRequest customerRequest) {
        return customerConverter.convert(customerRepository.save(customerConverter.convert(customerRequest)));
    }

    @Override
    public CustomerResponse findById(@Valid @NotNull UUID id) {
        return customerRepository.findById(id)
                .map(customerConverter::convert)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public CustomerResponse update(@Valid @NotNull UUID id, @Valid @NotNull CustomerRequest customerRequest) {
        return customerRepository.findById(id)
                .stream()
                .peek(item -> customerConverter.merge(item, customerConverter.convert(customerRequest)))
                .map(customerRepository::save)
                .map(customerConverter::convert)
                .findAny()
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public void delete(@Valid @NotNull UUID id) {
        customerRepository.deleteById(id);
    }
}
