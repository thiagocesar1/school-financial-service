package br.com.school.financialservice.wallet.service.impl;

import br.com.school.financialservice.card.domain.Card;
import br.com.school.financialservice.card.service.CardService;
import br.com.school.financialservice.client.domain.Client;
import br.com.school.financialservice.wallet.domain.Wallet;
import br.com.school.financialservice.wallet.domain.WalletRepository;
import br.com.school.financialservice.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private CardService cardService;

    @Override
    public Wallet generateWallet(Client client, Card card) {
        Wallet wallet = Wallet.builder().client(client).build();
        walletRepository.save(wallet);

        return wallet;
    }
}
