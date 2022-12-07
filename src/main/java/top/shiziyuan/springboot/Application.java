package top.shiziyuan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import top.shiziyuan.springboot.domain.User;
import top.shiziyuan.springboot.log.LogUtil;

@EnableAsync
@EnableScheduling
@SpringBootApplication
@PropertySource("file:E:/conf/application.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        LogUtil.info("app start...");

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user = (User) context.getBean("user");
//        System.out.println(user.getAge());
//        System.out.println(user.getName());
    }

}
