package br.com.stamp.service;

import br.com.stamp.dto.CardDto;
import org.springframework.transaction.annotation.Transactional;

public interface Imprint {

    @Transactional
    CardDto mark(int storeId, int customerId);
}
