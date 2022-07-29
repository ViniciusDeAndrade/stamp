package br.com.stamp.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StoreDto {

    private Integer id;
    private String name;
    private AddressDto address;

}
