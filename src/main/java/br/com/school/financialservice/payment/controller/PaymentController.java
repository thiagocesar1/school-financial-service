package br.com.school.financialservice.payment.controller;

import br.com.school.financialservice.payment.mapping.PaymentDTO;
import br.com.school.financialservice.payment.mapping.PaymentMapper;
import br.com.school.financialservice.payment.service.PaymentService;
import br.com.school.financialservice.payment.domain.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void firstBuy(@Valid @RequestBody PaymentDTO paymentDTO) throws JsonProcessingException {
        Payment payment = PaymentMapper.INSTANCE.toPayment(paymentDTO);
        paymentService.createPaymentAndAdditionalItems(payment);
    }
}
