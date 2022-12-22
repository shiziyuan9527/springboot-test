package top.shiziyuan.springboot.testaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("top.shiziyuan.springboot.testaop")
@MyEnableAspectJAutoProxy
public class AppConfig {
}
