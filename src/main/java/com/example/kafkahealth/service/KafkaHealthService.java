package com.example.kafkahealth.service;

import com.example.kafkahealth.dto.KafkaHealthResponse;
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

    public KafkaHealthResponse getKafkaStatus() {
        try {
            DescribeClusterResult result = adminClient.describeCluster();
            String clusterId = result.clusterId().get(5, TimeUnit.SECONDS);
            Collection<Node> nodes = result.nodes().get(5, TimeUnit.SECONDS);

            return KafkaHealthResponse.builder()
                    .healthy(true)
                    .clusterId(clusterId)
                    .brokerCount(nodes.size())
                    .build();
//            return new KafkaHealthResponse(true, clusterId, nodes.size(), null);
        } catch (Exception e) {
            return KafkaHealthResponse.builder()
                    .healthy(false)
                    .error(e.getMessage())
                    .build();
//            return new KafkaHealthResponse(false, null, 0, e.getMessage());
        }
    }
}
