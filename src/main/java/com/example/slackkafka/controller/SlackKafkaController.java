package com.example.slackkafka.controller;

import com.example.slackkafka.service.KafkaTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slack")
@RequiredArgsConstructor
public class SlackKafkaController {

    private final KafkaTopicService kafkaTopicService;

    @PostMapping("/topic")
    public ResponseEntity<String> createTopic(@RequestParam("text") String topicName) {
        kafkaTopicService.createTopic(topicName);
        return ResponseEntity.ok("✅ 토픽 '" + topicName + "' 생성 완료!");
    }
}
