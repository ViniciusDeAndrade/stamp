package br.com.stamp.controller;

import br.com.stamp.dto.CardDto;
import br.com.stamp.form.StoreForm;
import br.com.stamp.service.Imprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping("v1/store")
public class StoreController {

    @Autowired
    private Imprint imprintService;

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
}
