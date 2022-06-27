package br.com.school.financialservice.client.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
    @NotEmpty(message = "Name is mandatory.")
    @NotNull
    private String name;

    @NotEmpty(message = "Email is mandatory.")
    @NotNull
    @Email
    private String email;

    @NotEmpty(message = "Lead ID is mandatory.")
    @NotNull
    private String marketingLeadId;

    @NotEmpty(message = "Document is mandatory.")
    @NotNull
    private String document;
}
