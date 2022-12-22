package top.shiziyuan.springboot.testaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        IUserService userService = (IUserService) ctx.getBean("userService");
        userService.test();
    }
}
