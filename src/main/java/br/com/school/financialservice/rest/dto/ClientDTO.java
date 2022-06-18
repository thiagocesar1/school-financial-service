package br.com.school.financialservice.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
    private String name;
    private String email;
    private String marketingLeadId;
    private String document;
}
