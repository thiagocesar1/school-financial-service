package br.com.school.financialservice.wallet.service;

import br.com.school.financialservice.card.domain.Card;
import br.com.school.financialservice.client.domain.Client;
import br.com.school.financialservice.wallet.domain.Wallet;

public interface WalletService {
    Wallet generateWallet(Client client, Card card);
}
