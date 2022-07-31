package com.learn.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String send(String topic, String payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
        try{
            kafkaTemplate.send(topic, payload);
        }catch(Exception e){
            LOGGER.error("Error sending payload='{}' to topic='{}'", payload, topic);
            throw new RuntimeException("Error sending payload='" + payload + "' to topic='" + topic + "'");
        }
        return "Message sent";
    }
}
