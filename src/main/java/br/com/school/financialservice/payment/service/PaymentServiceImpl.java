package br.com.school.financialservice.payment.service;

import br.com.school.financialservice.card.domain.Card;
import br.com.school.financialservice.card.service.CardService;
import br.com.school.financialservice.client.domain.Client;
import br.com.school.financialservice.client.service.ClientService;
import br.com.school.financialservice.payment.domain.Payment;
import br.com.school.financialservice.payment.domain.PaymentRepository;
import br.com.school.financialservice.payment.enums.PaymentStatus;
import br.com.school.financialservice.payment.service.PaymentService;
import br.com.school.financialservice.wallet.domain.Wallet;
import br.com.school.financialservice.wallet.service.WalletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private CardService cardService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void firstBuy(Payment payment) throws JsonProcessingException {
        Client client = clientService.save(payment.getClient());
        Wallet wallet = walletService.generateWallet(client, payment.getCard());

        payment.getCard().setWallet(wallet);
        Card card = cardService.addCard(payment.getCard());

        payment.setClient(client);
        payment.setCard(card);
        this.save(payment);
        this.processPayment(payment);
    }

    @Override
    @Transactional
    public void save(Payment payment){
        payment.setDate(LocalDate.now());
        payment.setStatus(PaymentStatus.WAITING_PROCCESS);
        paymentRepository.save(payment);
    }

    private void processPayment(Payment payment){
        cardService.validateCard(payment.getCard());
        payment.setStatus(PaymentStatus.OK);
        paymentRepository.save(payment);
    }
}
