package br.com.stamp.service.impl;

import br.com.stamp.dto.CustomerDto;
import br.com.stamp.form.CustomerForm;
import br.com.stamp.model.Customer;
import br.com.stamp.repository.CustomerRepository;
import br.com.stamp.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(int customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("no customer with this id"));
    }

    @Override
    public CustomerDto createCustomer(CustomerForm customerForm) {
        return null;
    }
}
