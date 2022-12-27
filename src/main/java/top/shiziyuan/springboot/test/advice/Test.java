package top.shiziyuan.springboot.test.advice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        IUserService userService = (IUserService) ctx.getBean("userService");
        userService.test();
    }
}
