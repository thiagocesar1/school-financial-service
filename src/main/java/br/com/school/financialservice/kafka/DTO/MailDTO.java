package br.com.school.financialservice.kafka.DTO;

import br.com.school.financialservice.kafka.enums.MailType;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class MailDTO {
    private String mailTo;
    private Map<String, String> attributes;
    private MailType mailType;
}
