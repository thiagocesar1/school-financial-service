package br.com.school.financialservice.payment.service;

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
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void firstBuy(Payment payment) throws JsonProcessingException {
        Client client = clientService.save(payment.getClient());
        Wallet wallet = walletService.generateWallet(client, payment.getFirstBuyCard());
        client.setWallet(wallet);
        payment.setClient(client);
        this.save(payment);
    }

    @Override
    @Transactional
    public void save(Payment payment){
        payment.setDate(LocalDate.now());
        payment.setStatus(PaymentStatus.WAITING_PROCCESS);
        paymentRepository.save(payment);
    }


}
