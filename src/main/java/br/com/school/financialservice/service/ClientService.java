package br.com.school.financialservice.service;

import br.com.school.financialservice.domain.entity.Client;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ClientService {
    Client save(Client client) throws JsonProcessingException;
}
