package br.com.stamp.controller;

import br.com.stamp.dto.CardDto;
import br.com.stamp.dto.StoreDto;
import br.com.stamp.form.StoreForm;
import br.com.stamp.service.IStoreService;
import br.com.stamp.service.Imprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("v1/store")
public class StoreController {

    @Autowired
    private Imprint imprintService;

    @Autowired
    private IStoreService storeService;

    @PostMapping("{storeId}/customer/{customerId}")
    public ResponseEntity<CardDto> mark(
            @PathVariable("storeId") int storeId,
            @PathVariable("customerId") int customerId,
            UriComponentsBuilder uriComponentsBuilder
    ) {
       var card = imprintService.mark(storeId, customerId);

       var uri = uriComponentsBuilder
               .path("v1/store/{storeId}/customer/{customerId}")
               .buildAndExpand(
                       Map.of("storeId", storeId, "customerId", customerId)
               ).toUri();

       return ResponseEntity.created(uri).body(card);
    }

    @PostMapping
    public ResponseEntity<StoreDto> createStore(@RequestBody StoreForm storeForm, UriComponentsBuilder uriComponentsBuilder) {
        var store = storeService.createStore(storeForm);

        var uri = uriComponentsBuilder.path("v1/store").build().toUri();

        return ResponseEntity.created(uri).body(store);
    }
}
