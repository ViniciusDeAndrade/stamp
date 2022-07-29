package br.com.stamp.service.impl;

import br.com.stamp.dto.CardDto;
import br.com.stamp.service.Imprint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImprintService implements Imprint {

    @Autowired
    private CardService cardService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StoreService storeService;

    @Override
    public CardDto mark(int storeId, int customerId) {
        var opCard = cardService.findByStoreIdAndCustomersId(storeId, customerId);
        if(opCard.isPresent()) {
            var card = opCard.get();
            card.markStamp();
            cardService.save(card);
            return card.toCardDto();

        } else return cardService
                .emitCard(storeId, customerId)
                .toCardDto();


    }

}
