package br.com.school.financialservice.card.mapping;

import br.com.school.financialservice.card.enums.CardType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardDTO {
    private String numbers;
    private String validationCode;
    private LocalDate validationDate;
    private CardType type;
    private String ownerName;
}
