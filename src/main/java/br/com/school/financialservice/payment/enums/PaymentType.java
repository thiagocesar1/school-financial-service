package br.com.school.financialservice.payment.enums;

import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

@Getter
public enum PaymentType {
    DEBIT(1, "Debito"),
    CREDIT(2, "Credito"),
    PIX(3, "Pix");

    private final Integer code;
    private final String name;

    PaymentType(final int code, final String name) {
        this.code = code;
        this.name = name;
    }
}
