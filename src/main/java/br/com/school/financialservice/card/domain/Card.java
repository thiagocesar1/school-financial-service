package br.com.school.financialservice.card.domain;

import br.com.school.financialservice.card.enums.CardType;
import br.com.school.financialservice.wallet.domain.Wallet;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String numbers;

    @Column
    private String validationCode;

    @Column(name = "validation_date")
    private LocalDate validationDate;

    @Enumerated(EnumType.STRING)
    @Column
    private CardType type;

    @Column(name = "owner_name")
    private String ownerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    private boolean validateCreditCard() {
        if(this.numbers.isBlank()) return false;

        final boolean[] flag = {(this.numbers.length() & 1) == 1};
        return Arrays.stream(
                        this.numbers.split(""))
                .map(Integer::parseInt)
                .mapToInt(value -> value)
                .map(integer -> ((flag[0] ^= true) ? (integer * 2 - 1) % 9 + 1 : integer))
                .sum() % 10 == 0;
    }

    private boolean validateDebitCard() {
        return true;
    }

    public boolean validate(){
        switch(this.type) {
            case CREDIT:
                return validateCreditCard();
            case DEBIT:
                return validateDebitCard();
            default:
                return true;
        }
    }
}
