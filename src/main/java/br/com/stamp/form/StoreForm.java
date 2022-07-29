package br.com.stamp.form;

import br.com.stamp.model.Store;
import lombok.Getter;


@Getter
public class StoreForm {
    private String cnpj;
    private String name;
    private AddressForm address;

    public Store toStoreModel() {
        return new Store(
            this.cnpj,
            this.name,
            this.address.toAddressModel()
        );
    }
}
