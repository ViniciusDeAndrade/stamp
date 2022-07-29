package br.com.stamp.form;

import lombok.Getter;


@Getter
public class StoreForm {
    private String cnpj;
    private String name;
    private AddressForm address;
}
