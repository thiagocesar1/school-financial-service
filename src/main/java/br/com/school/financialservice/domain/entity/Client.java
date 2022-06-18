package br.com.school.financialservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

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
}
