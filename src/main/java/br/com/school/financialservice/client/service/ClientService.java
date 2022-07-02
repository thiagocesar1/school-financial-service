package br.com.school.financialservice.client.service;

import br.com.school.financialservice.client.domain.Client;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ClientService {
    Client save(Client client);

     void sendClientToKafka(Client client);
}
