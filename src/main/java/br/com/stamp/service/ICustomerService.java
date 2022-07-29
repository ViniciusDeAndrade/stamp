package br.com.stamp.service;

import br.com.stamp.dto.CustomerDto;
import br.com.stamp.form.CustomerForm;
import br.com.stamp.model.Customer;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerService {

    Customer getCustomer(int customerId);

    @Transactional
    CustomerDto createCustomer(CustomerForm customerForm);
}
