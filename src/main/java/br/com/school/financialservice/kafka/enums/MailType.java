package br.com.school.financialservice.kafka.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MailType {
    PAYMENT_APPROVED_MAIL(3);

    private final Integer code;
}
