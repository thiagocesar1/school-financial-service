package br.com.school.financialservice.card.mapping;

import br.com.school.financialservice.card.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private String numbers;
    private String validationCode;
    private String validationDate;
    private String type;
    private String ownerName;
}
