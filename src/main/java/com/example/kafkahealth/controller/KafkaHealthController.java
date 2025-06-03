package com.example.kafkahealth.controller;

import com.example.kafkahealth.dto.KafkaHealthResponse;
import com.example.kafkahealth.service.KafkaHealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slack")
@RequiredArgsConstructor
public class KafkaHealthController {

    private final KafkaHealthService kafkaHealthService;

    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KafkaHealthResponse> checkKafkaHealth() {
        KafkaHealthResponse response = kafkaHealthService.getKafkaStatus();
        return ResponseEntity.ok(response);
    }
}
