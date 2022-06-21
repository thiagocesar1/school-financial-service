package br.com.school.financialservice.service;

import br.com.school.financialservice.domain.entity.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PaymentService {
    void firstBuy(Payment payment) throws JsonProcessingException;
}
