package br.com.school.financialservice.payment.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum PaymentStatus {
    OK(1, "Finalizado"),
    WAITING_PROCCESS(2, "Processando"),
    CANCELED(3, "Cancelado");

    private final Integer code;
    private final String name;

    PaymentStatus(final int code, final String name) {
        this.code = code;
        this.name = name;
    }
}
