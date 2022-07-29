package br.com.stamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@Entity
public class Store {
    @Id
    @GeneratedValue
    private Integer id;
    private String cnpj;
    private String name;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "store")
    private List<Card> card;

}
