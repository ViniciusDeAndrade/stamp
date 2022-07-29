package br.com.stamp.model;

import br.com.stamp.dto.AddressDto;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;


    @NonNull
    private String street;
    @NonNull
    private String number ;
    @NonNull
    private String city;

    public AddressDto toAddressDto() {
        return new AddressDto(
            id,
            street,
            number,
            city
        );
    }

}
