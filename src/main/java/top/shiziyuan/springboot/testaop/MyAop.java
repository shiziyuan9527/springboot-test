package top.shiziyuan.springboot.testaop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

//@Component
public class MyAop implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return Proxy.newProxyInstance(MyAop.class.getClassLoader(), new Class[]{IUserService.class}, (proxy, method, arg) -> {
            System.out.println("---- before aop ----");
            return method.invoke(bean, arg);
        });
    }
}
