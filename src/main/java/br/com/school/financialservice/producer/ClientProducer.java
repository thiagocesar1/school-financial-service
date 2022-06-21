package br.com.school.financialservice.producer;

import br.com.school.financialservice.domain.entity.Client;
import com.netflix.discovery.converters.Auto;
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
    private static final String topic = "clients";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String client){
        kafkaTemplate.send(topic, client).addCallback(
                success -> logger.info("Message send."),
                failure -> logger.info("Message failed")
        );
    }
}
