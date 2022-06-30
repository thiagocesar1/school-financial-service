package br.com.school.financialservice.wallet.domain;

import br.com.school.financialservice.card.domain.Card;
import br.com.school.financialservice.client.domain.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wallet")
    private List<Card> cards;
}
