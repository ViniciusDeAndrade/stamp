package br.com.stamp.service;

import br.com.stamp.model.Card;
import br.com.stamp.repository.CardRepository;
import br.com.stamp.repository.CustomerRepository;
import br.com.stamp.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StoreService storeService;

    @Autowired
    private CustomerService customerService;


    public Card emitCard(Integer storeId, Integer customerId) {


        var store = storeService.getStore(storeId);
        var customer = customerService.getCustomer(customerId);
        var card = new Card(store, customer);
        this.save(card);
        return card;

    }

    public Optional<Card> findByStoreIdAndCustomersId(int storeId, int customerId) {
        return this.cardRepository.findByStoreIdAndCustomersId(storeId, customerId);
    }


    public void save(Card card) {
        this.cardRepository.save(card);
    }
}
