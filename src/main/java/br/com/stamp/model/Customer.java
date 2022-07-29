package br.com.stamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String cpf;

    private String name;

    @OneToOne
    private Address address;

    @ManyToMany(mappedBy = "customers")
    private List<Card> cards;
}
