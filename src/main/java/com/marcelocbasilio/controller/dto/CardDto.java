package com.marcelocbasilio.controller.dto;

import com.marcelocbasilio.domain.model.Card;

import java.math.BigDecimal;

public record CardDto(Long id, String number, BigDecimal limit) {

    public CardDto(Card card) {
        this(card.getId(), card.getNumber(), card.getLimit());
    }

    public Card toCard() {
        Card card = new Card();
        card.setId(this.id);
        card.setNumber(this.number);
        card.setLimit(this.limit);
        return card;
    }
}
