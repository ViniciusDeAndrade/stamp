package br.com.stamp.dto;

import java.util.List;

public class CardDto {

    private Integer cardId;
    private Integer storeId;
    private List<Integer> stampsIds;

    public CardDto(Integer cardId, Integer storeId, List<Integer> stampsIds) {
        this.cardId = cardId;
        this.storeId = storeId;
        this.stampsIds = stampsIds;
    }
}
