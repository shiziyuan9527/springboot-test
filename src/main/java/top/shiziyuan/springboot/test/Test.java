package top.shiziyuan.springboot.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        A a = (A) ctx.getBean("a");
        A a1 = (A) ctx.getBean("a");
        System.out.println(a);
        System.out.println(a1);
    }
}
