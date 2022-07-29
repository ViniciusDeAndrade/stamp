package br.com.stamp.controller;

import br.com.stamp.dto.CustomerDto;
import br.com.stamp.form.CustomerForm;
import br.com.stamp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerForm customerForm, UriComponentsBuilder uriComponentsBuilder) {

        var customer = customerService.createCustomer(customerForm);

        var uri = uriComponentsBuilder.path("v1/customer/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(customer);
    }
}
