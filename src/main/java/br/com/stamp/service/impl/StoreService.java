package br.com.stamp.service.impl;

import br.com.stamp.dto.StoreDto;
import br.com.stamp.form.StoreForm;
import br.com.stamp.model.Store;
import br.com.stamp.repository.StoreRepository;
import br.com.stamp.service.IStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StoreService implements IStoreService {

    @Autowired
    private StoreRepository storeRepository;


    public Store getStore(Integer storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(
                        () -> new RuntimeException("no store with this id")
                );
    }

    public StoreDto createStore(StoreForm storeForm) {

        return storeRepository.save(storeForm.toStoreModel()).toStoreDto();

    }
}
