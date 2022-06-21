package br.com.school.financialservice.service.impl;

import br.com.school.financialservice.domain.entity.Client;
import br.com.school.financialservice.domain.entity.Payment;
import br.com.school.financialservice.domain.enums.PaymentStatus;
import br.com.school.financialservice.domain.repository.ClientRepository;
import br.com.school.financialservice.domain.repository.PaymentRepository;
import br.com.school.financialservice.producer.ClientProducer;
import br.com.school.financialservice.service.ClientService;
import br.com.school.financialservice.service.PaymentService;
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
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void firstBuy(Payment payment) throws JsonProcessingException {
        Client client = clientService.save(payment.getClient());
        payment.setDate(LocalDate.now());
        payment.setStatus(PaymentStatus.WAITING_PROCCESS);
        payment.setClient(client);
        paymentRepository.save(payment);
    }
}
