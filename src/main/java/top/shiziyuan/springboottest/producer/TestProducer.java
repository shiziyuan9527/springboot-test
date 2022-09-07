package top.shiziyuan.springboottest.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import top.shiziyuan.springboottest.constants.KafkaTopicConstants;

import javax.annotation.Resource;

@Component
public class TestProducer {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void test() {
        kafkaTemplate.send(KafkaTopicConstants.TEST_TOPIC, "hello world");
    }
}
