package br.com.school.financialservice.client.service;

import br.com.school.financialservice.client.domain.Client;
import br.com.school.financialservice.client.domain.ClientRepository;
import br.com.school.financialservice.client.producer.ClientProducer;
import br.com.school.financialservice.client.service.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public Client save(Client client){
        client = clientRepository.save(client);

        return client;
    }

    @Override
    public void sendClientToKafka(Client client){
        try {
            clientProducer.send(objectMapper.writeValueAsString(client));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
