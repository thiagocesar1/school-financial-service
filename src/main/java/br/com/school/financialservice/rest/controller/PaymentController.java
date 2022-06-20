package br.com.school.financialservice.rest.controller;

import br.com.school.financialservice.domain.entity.Payment;
import br.com.school.financialservice.domain.enums.PaymentType;
import br.com.school.financialservice.rest.dto.PaymentDTO;
import br.com.school.financialservice.service.PaymentService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void firstBuy(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        paymentService.firstBuy(payment);
    }
}
