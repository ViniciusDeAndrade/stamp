package br.com.stamp.form;

import lombok.Getter;

@Getter
public class CustomerForm {
    private String cpf;

    private String name;

    private AddressForm address;
}
