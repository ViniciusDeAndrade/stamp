package br.com.stamp.service;

import br.com.stamp.model.Store;
import br.com.stamp.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store getStore(int storeId) {
        return storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("no store with this id"));
    }

}
