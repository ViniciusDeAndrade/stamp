package br.com.stamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;
    private String street;
    private String number = "S/N";
    private String city;

}
