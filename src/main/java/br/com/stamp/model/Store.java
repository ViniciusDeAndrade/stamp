package br.com.stamp.model;



import br.com.stamp.dto.StoreDto;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Store {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String cnpj;

    @NonNull
    private String name;

    @NonNull
    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "store")
    private List<Card> card = new ArrayList<>();

    public StoreDto toStoreDto() {
        return new StoreDto(
            id,
            name,
            address.toAddressDto()
        );
    }

}
