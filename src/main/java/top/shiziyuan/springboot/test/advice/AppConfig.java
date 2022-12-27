package top.shiziyuan.springboot.test.advice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("top.shiziyuan.springboot.test.advice")
@MyEnableAspectJAutoProxy
public class AppConfig {
}
