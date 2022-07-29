package br.com.stamp.form;

import br.com.stamp.model.Address;
import lombok.Getter;

@Getter
public class AddressForm {
    private Integer id;
    private String street;
    private String number = "S/N";
    private String city;

    public Address toAddressModel() {
        return new Address(
            this.street,
            this.number,
            this.city
        );
    }

}
