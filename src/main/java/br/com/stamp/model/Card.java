package br.com.stamp.model;


import br.com.stamp.dto.CardDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity(name = "cards")
@Table
public class Card {

    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    @ManyToOne
    private Store store;

    @NonNull
    @ManyToMany
    private List<Customer> customers = new LinkedList<>();

    @OneToMany
    @Getter(value = AccessLevel.NONE)
    private List<Stamp> stamps = new LinkedList<>();

    public Card() {}
    public Card(Store store, Customer customer) {
        this.store = store;
        this.customers.add(customer);
        this.markStamp();
    }

    public void markStamp() {
        this.stamps.add(new Stamp());
    }

    public CardDto toCardDto(){
        return new CardDto(
                this.id,
                this.store.getId(),
                this.stamps.stream().map(Stamp::getId).collect(Collectors.toList())
        );
    }

}
