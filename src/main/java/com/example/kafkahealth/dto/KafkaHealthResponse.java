package com.example.kafkahealth.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class KafkaHealthResponse {
    private boolean healthy;
    private String clusterId;
    private int brokerCount;
    private String error;
}
