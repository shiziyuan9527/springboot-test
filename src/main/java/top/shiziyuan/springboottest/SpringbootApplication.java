package top.shiziyuan.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.shiziyuan.springboottest.config.MyConfig;
import top.shiziyuan.springboottest.domain.Pet;
import top.shiziyuan.springboottest.domain.User;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);

        MyConfig myConfig = run.getBean(MyConfig.class);
        System.out.println(myConfig);

//        User user = run.getBean("user", User.class);
//        Pet pet = run.getBean("pet", Pet.class);
//        System.out.println(user.getPet() == pet);


//        String[] beanNames = run.getBeanDefinitionNames();  // spring管理的 bean name
//        for (String name : beanNames) {
//            System.out.println(name);
//        }
    }

}
