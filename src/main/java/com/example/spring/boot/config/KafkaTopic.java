package com.example.spring.boot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
     @Bean
    public NewTopic exampleTopic(){
        return TopicBuilder.name("topicOne").build();
    }

    @Bean
    public NewTopic exampleJsonTopic(){
        return TopicBuilder.name("JsonTopicOne").build();
    }
}
