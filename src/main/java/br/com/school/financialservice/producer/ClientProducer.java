package br.com.school.financialservice.producer;

import br.com.school.financialservice.domain.entity.Client;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientProducer {
    private static final Logger logger = LoggerFactory.getLogger(ClientProducer.class);
    private final String topic;
    private final KafkaTemplate<String, Client> kafkaTemplate;

    public void send(Client client){
        kafkaTemplate.send(topic, client).addCallback(
                success -> logger.info("Message send."),
                failure -> logger.info("Message failed")
        );
    }
}
