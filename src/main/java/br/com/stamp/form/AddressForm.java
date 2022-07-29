package br.com.stamp.form;

import lombok.Getter;

@Getter
public class AddressForm {
    private Integer id;
    private String street;
    private String number = "S/N";
    private String city;

}
