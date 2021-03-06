package br.com.school.financialservice.client.producer;

import br.com.school.financialservice.client.domain.Client;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientProducer {
    private static final Logger logger = LoggerFactory.getLogger(ClientProducer.class);
    private static final String topic = "client_added";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(Client client){
        kafkaTemplate.send(topic, client).addCallback(
                success -> logger.info("Message send."),
                failure -> logger.info("Message failed")
        );
    }
}
