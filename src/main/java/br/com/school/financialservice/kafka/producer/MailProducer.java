package br.com.school.financialservice.kafka.producer;


import br.com.school.financialservice.kafka.DTO.MailDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MailProducer {
    private static final Logger logger = LoggerFactory.getLogger(MailProducer.class);
    private static final String topic = "mail";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMail(MailDTO mail){
        kafkaTemplate.send(topic, mail).addCallback(
                success -> logger.info("Message send."),
                failure -> logger.info("Message failed")
        );
    }
}
