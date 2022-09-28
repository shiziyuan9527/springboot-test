package top.shiziyuan.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import top.shiziyuan.springboottest.config.MyConfig;

@EnableAsync
@EnableScheduling
@SpringBootApplication
@PropertySource("file:/opt/metersphere/conf/application.properties")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
//        MyConfig myConfig = run.getBean(MyConfig.class);
//        System.out.println(myConfig);

//        boolean hasPet = run.containsBean("pet");
//        System.out.println("has pet: " + hasPet);
//        boolean hasUser = run.containsBean("user");
//        System.out.println("has user: " + hasUser);

//        User user = run.getBean("user", User.class);
//        Pet pet = run.getBean("pet", Pet.class);
//        System.out.println(user.getPet() == pet);


//        String[] beanNames = run.getBeanDefinitionNames();  // spring管理的 bean name
//        for (String name : beanNames) {
//            System.out.println(name);
//        }
    }

}
