package br.com.school.financialservice.client.domain;

import br.com.school.financialservice.payment.domain.Payment;
import br.com.school.financialservice.wallet.domain.Wallet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column(name = "marketing_lead_id")
    private String marketingLeadId;

    @Column
    private String document;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Payment> payments;

    @OneToOne(mappedBy = "client")
    private Wallet wallet;
}
