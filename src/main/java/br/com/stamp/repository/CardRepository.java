package br.com.stamp.repository;

import br.com.stamp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {

    Optional<Card> findByStoreIdAndCustomersId(int storeId, int customerId);
}
