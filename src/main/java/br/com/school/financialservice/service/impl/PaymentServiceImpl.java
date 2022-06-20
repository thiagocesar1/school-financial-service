package br.com.school.financialservice.service.impl;

import br.com.school.financialservice.domain.entity.Client;
import br.com.school.financialservice.domain.entity.Payment;
import br.com.school.financialservice.domain.enums.PaymentStatus;
import br.com.school.financialservice.domain.repository.ClientRepository;
import br.com.school.financialservice.domain.repository.PaymentRepository;
import br.com.school.financialservice.service.PaymentService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void firstBuy(Payment payment) {
        Client client = clientRepository.save(payment.getClient());
        payment.setDate(LocalDate.now());
        payment.setStatus(PaymentStatus.WAITING_PROCCESS);
        payment.setClient(client);
        paymentRepository.save(payment);
    }
}
