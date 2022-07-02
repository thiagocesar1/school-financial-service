package br.com.school.financialservice.card.controller;

import br.com.school.financialservice.payment.domain.Payment;
import br.com.school.financialservice.payment.mapping.PaymentDTO;
import br.com.school.financialservice.payment.mapping.PaymentMapper;
import br.com.school.financialservice.payment.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void firstBuy(@Valid @RequestBody PaymentDTO paymentDTO) throws JsonProcessingException {
        Payment payment = PaymentMapper.INSTANCE.toPayment(paymentDTO);
        paymentService.firstBuy(payment);
    }
}
