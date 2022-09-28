package top.shiziyuan.springboottest.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import top.shiziyuan.springboottest.constants.KafkaTopicConstants;

@Configuration
public class KafkaTopicConfig {

//    @Value("${kafka.partitions:2}")
//    private Integer partitions;
//    @Value("${kafka.replicas:1}")
//    private Integer replicas;
//
//    @Bean
//    public NewTopic testTopic() {
//        return TopicBuilder.name(KafkaTopicConstants.TEST_TOPIC)
//                .partitions(partitions)
//                .replicas(replicas)
//                .build();
//    }
}
