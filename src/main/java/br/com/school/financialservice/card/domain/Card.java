package br.com.school.financialservice.card.domain;

import br.com.school.financialservice.card.enums.CardType;
import br.com.school.financialservice.wallet.domain.Wallet;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Card {
    @Id
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
}
