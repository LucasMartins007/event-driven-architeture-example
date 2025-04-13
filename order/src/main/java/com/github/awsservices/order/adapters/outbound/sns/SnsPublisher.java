package com.github.awsservices.order.adapters.outbound.sns;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.awsservices.order.application.core.domain.OrderEvent;
import com.github.awsservices.order.application.core.ports.outbound.SnsPublisherPort;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

public class SnsPublisher implements SnsPublisherPort {

    private final SnsClient snsClient;

    private final String topicName;

    private final ObjectMapper mapper = new ObjectMapper();

    public SnsPublisher(SnsClient snsClient, String topicName) {
        this.snsClient = snsClient;
        this.topicName = topicName;
    }

    @Override
    public void publish(OrderEvent orderEvent) {
        try {
            final String orderEventMessage = mapper.writeValueAsString(orderEvent);
            final PublishRequest request = PublishRequest.builder()
                    .topicArn(topicName)
                    .message(orderEventMessage)
                    .build();

            snsClient.publish(request);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao publicar evento", e);
        }
    }

}