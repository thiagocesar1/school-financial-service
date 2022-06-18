package br.com.school.financialservice.domain.entity;

import br.com.school.financialservice.domain.enums.PaymentStatus;
import br.com.school.financialservice.domain.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    @Column
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    @Column
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
