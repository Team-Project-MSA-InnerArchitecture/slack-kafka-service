package com.example.kafkahealth.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeClusterResult;
import org.apache.kafka.common.Node;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class KafkaHealthService {
    private final AdminClient adminClient;

    public String getKafkaStatusMessage() {
        try {
            DescribeClusterResult result = adminClient.describeCluster();
            String clusterId = result.clusterId().get(5, TimeUnit.SECONDS);
            Collection<Node> nodes = result.nodes().get(5, TimeUnit.SECONDS);

            return String.format("*Kafka 상태 보고서* :\n• 상태: ✅ 정상\n• 클러스터 ID: `%s`\n• 브로커 수: %d",
                    clusterId, nodes.size());
        } catch (Exception e) {
            return String.format("*Kafka 상태 보고서* :\n• 상태: ❌ 오류 발생\n• 에러 메시지: `%s`",
                    e.getMessage());
        }
    }
}
