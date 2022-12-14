package br.com.stamp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StoreDto {

    private Integer id;
    private String name;
    private AddressDto address;

}
