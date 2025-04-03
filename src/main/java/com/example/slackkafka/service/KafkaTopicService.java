package com.example.slackkafka.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaTopicService {

    private final KafkaAdmin kafkaAdmin;

    public void createTopic(String topicName) {
        NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);
        kafkaAdmin.createOrModifyTopics(newTopic);
    }
}
