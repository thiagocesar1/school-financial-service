package br.com.school.financialservice.card.service.impl;

import br.com.school.financialservice.card.domain.Card;
import br.com.school.financialservice.card.domain.CardRepository;
import br.com.school.financialservice.card.exception.InvalidCardException;
import br.com.school.financialservice.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.TemporalAdjusters;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card addCard(Card card) {
        card.setValidationDate(card.getValidationDate().with(TemporalAdjusters.lastDayOfMonth()));
        return cardRepository.save(card);
    }

    @Override
    public void validateCard(Card card){
        if(!card.validate()){
            throw new InvalidCardException("Cartão inválido, atualize os dados e realize uma nova tentativa!");
        }
    }
}
