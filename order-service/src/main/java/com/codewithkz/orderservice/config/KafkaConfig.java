package com.codewithkz.orderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Value("${app.kafka.topic.reserve-inventory-command}")
    private String reserveInventoryCommandTopicName;
    @Value("${app.kafka.topic.create-payment-command}")
    private String createPaymentCommandTopicName;

    @Bean
    public NewTopic reserveInventoryTopic() {
        return TopicBuilder
                .name(reserveInventoryCommandTopicName)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic createPaymentTopicName() {
        return TopicBuilder
                .name(createPaymentCommandTopicName)
                .partitions(3)
                .replicas(1)
                .build();
    }
}
