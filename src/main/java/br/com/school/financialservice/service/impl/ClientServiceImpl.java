package br.com.school.financialservice.service.impl;

import br.com.school.financialservice.domain.entity.Client;
import br.com.school.financialservice.domain.repository.ClientRepository;
import br.com.school.financialservice.producer.ClientProducer;
import br.com.school.financialservice.service.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientProducer clientProducer;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Client save(Client client) throws JsonProcessingException {
        client = clientRepository.save(client);
        clientProducer.send(objectMapper.writeValueAsString(client));
        return client;
    }
}
