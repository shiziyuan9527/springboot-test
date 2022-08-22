package top.shiziyuan.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.shiziyuan.springboottest.domain.Pet;
import top.shiziyuan.springboottest.domain.User;

// proxyBeanMethods = false 不再是代理对象。意味着不做bean存在与否的检查，直接调用原始类的方法，会提升效率。
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    @Bean
    public Pet pet() {
        return new Pet("pet", 13);
    }

    @Bean
    public User user() {
        return new User("oliver", 25, pet());
    }
}
