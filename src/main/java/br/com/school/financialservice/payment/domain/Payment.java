package br.com.school.financialservice.payment.domain;

import br.com.school.financialservice.client.domain.Client;
import br.com.school.financialservice.payment.enums.PaymentStatus;
import br.com.school.financialservice.payment.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "payment_date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column
    private PaymentType type;

    @Enumerated(EnumType.STRING)
    @Column
    private PaymentStatus status;

    @Column
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public void cancelTransaction(){
        this.setStatus(PaymentStatus.CANCELED);
    }

    public void endTransaction(){
        this.setStatus(PaymentStatus.OK);
    }
}
