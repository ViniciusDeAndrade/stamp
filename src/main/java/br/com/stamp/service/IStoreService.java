package br.com.stamp.service;

import br.com.stamp.dto.StoreDto;
import br.com.stamp.form.StoreForm;
import br.com.stamp.model.Store;
import org.springframework.transaction.annotation.Transactional;

public interface IStoreService {

    StoreDto getStore(Integer storeId);
    @Transactional
    StoreDto createStore(StoreForm storeForm);
}
