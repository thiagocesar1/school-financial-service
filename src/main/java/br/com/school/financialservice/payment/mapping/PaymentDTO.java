package br.com.school.financialservice.payment.mapping;

import br.com.school.financialservice.card.mapping.CardDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    @NotBlank(message = "Client name is mandatory.")
    private String clientName;

    @NotBlank(message = "Client email is mandatory.")
    @Email(message = "Invalid Email.")
    private String clientEmail;

    @NotBlank(message = "Client Lead ID is mandatory.")
    private String clientMarketingLeadId;

    @NotBlank(message = "Client document is mandatory.")
    private String clientDocument;

    @NotBlank(message = "Payment type is mandatory.")
    private String type;

    @NotNull(message = "Payment value is mandatory.")
    @DecimalMin(value = "0.01", inclusive = false, message = "Payment value needs to be greater than 0")
    private BigDecimal value;

    private CardDTO card;
}
