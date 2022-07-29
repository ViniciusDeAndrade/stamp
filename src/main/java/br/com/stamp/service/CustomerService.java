package br.com.stamp.service;

import br.com.stamp.model.Customer;
import br.com.stamp.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(int customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("no customer with this id"));
    }

}
