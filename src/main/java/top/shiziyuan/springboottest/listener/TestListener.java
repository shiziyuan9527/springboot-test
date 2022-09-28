package top.shiziyuan.springboottest.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import top.shiziyuan.springboottest.constants.KafkaTopicConstants;

@Component
public class TestListener {

//    @KafkaListener(id = "test", topics = KafkaTopicConstants.TEST_TOPIC, groupId = "${spring.application.name}")
//    public void listener(ConsumerRecord<?, String> record) {
//        System.out.println(record);
//    }
}
