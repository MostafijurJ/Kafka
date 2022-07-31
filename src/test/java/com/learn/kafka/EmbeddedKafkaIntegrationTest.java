package com.learn.kafka;

import com.learn.kafka.consumer.KafkaConsumer;
import com.learn.kafka.producer.KafkaProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class EmbeddedKafkaIntegrationTest {

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaProducer producer;

    @Value("${test.topic}")
    private String topic;

    @Test
    public void testKafka() {
        String data = "Sending with our own simple KafkaProducer";

        producer.send(topic, data);

  /*      boolean messageConsumed = consumer.resetLatch().await(10, TimeUnit.SECONDS);
        assertTrue(messageConsumed);
        assertThat(consumer.getPayload(), containsString(data));*/
    }
}