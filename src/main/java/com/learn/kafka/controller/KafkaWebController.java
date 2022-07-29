package com.learn.kafka.controller;

import com.learn.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaWebController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public String send(@RequestParam("topic") String topic, @RequestParam("payload") String payload) {
        kafkaProducer.send(topic, payload);
        return "Message sent";
    }
}
