package br.com.stamp.repository;

import br.com.stamp.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Integer> {

}
