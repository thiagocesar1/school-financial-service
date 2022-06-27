package br.com.school.financialservice.payment.mapping;

import br.com.school.financialservice.client.mapping.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    @NotNull
    private ClientDTO client;

    @NotEmpty(message = "Payment type is mandatory.")
    @NotNull
    private String type;

    @NotNull
    private BigDecimal value;
}
