package com.example.kafkahealth.controller;

import com.example.kafkahealth.service.KafkaHealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slack")
@RequiredArgsConstructor
public class KafkaHealthController {

    private final KafkaHealthService kafkaHealthService;

    @PostMapping (value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkKafkaHealth() {
        String response = kafkaHealthService.getKafkaStatusMessage();
        return ResponseEntity.ok(response);
    }
}
