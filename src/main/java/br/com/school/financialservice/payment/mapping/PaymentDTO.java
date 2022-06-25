package br.com.school.financialservice.payment.mapping;

import br.com.school.financialservice.client.mapping.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private ClientDTO client;
    private BigDecimal total;
    private String type;
    private BigDecimal value;
}
