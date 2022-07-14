package br.com.school.financialservice.payment.service;

import br.com.school.financialservice.payment.domain.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PaymentService {
    void createPaymentAndAdditionalItems(Payment payment) throws JsonProcessingException;
    void save(Payment payment);
}
