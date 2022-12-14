package top.shiziyuan.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.shiziyuan.springboot.domain.*;

// proxyBeanMethods = false 不再是代理对象。意味着不做bean存在与否的检查，直接调用原始类的方法，会提升效率。
@Configuration(proxyBeanMethods = true)
@EnableConfigurationProperties({Cat.class, Person.class}) // 启用Cat的配置属性绑定、把Cat交给Spring管理
public class MyConfig {

    @Bean
    public Pet pet() {
        return new Pet("pet", 13);
    }

    @Bean
    @ConditionalOnBean(name = "pet") // 有name为pet的bean时，才创建user bean
    public User user() {
        return new User("id", "oliver", 25, pet());
    }

    @Bean
    public Dog dog() {
        return new Dog("dog", 10);
    }
}
