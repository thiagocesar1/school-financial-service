package br.com.school.financialservice.card.service.impl;

import br.com.school.financialservice.card.domain.Card;
import br.com.school.financialservice.card.domain.CardRepository;
import br.com.school.financialservice.card.service.CardService;
import br.com.school.financialservice.wallet.domain.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public void addCard(Card card) {
        card.setValidationDate(card.getValidationDate().with(TemporalAdjusters.lastDayOfMonth()));
        cardRepository.save(card);
    }
}
