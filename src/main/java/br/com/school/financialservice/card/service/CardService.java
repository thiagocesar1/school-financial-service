package br.com.school.financialservice.card.service;

import br.com.school.financialservice.card.domain.Card;

public interface CardService {
    Card addCard(Card card);

    void validateCard(Card card);
}
