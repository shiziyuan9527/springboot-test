package top.shiziyuan.springboot.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import top.shiziyuan.springboot.constants.KafkaTopicConstants;

import javax.annotation.Resource;

@Component
public class TestProducer {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void test() {
        kafkaTemplate.send(KafkaTopicConstants.TEST_TOPIC, "hello world");
    }
}
