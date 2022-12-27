package top.shiziyuan.springboot.test.advice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class MyAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("========after=======");
    }
}
