package top.shiziyuan.springboot.test.advice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MyAop implements BeanPostProcessor, BeanFactoryAware {
    private ListableBeanFactory beanFactory;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (PointcutAdvisor.class.isAssignableFrom(bean.getClass())
                || Advice.class.isAssignableFrom(bean.getClass())) {
            return bean;
        }
        List<PointcutAdvisor> advisors = new ArrayList<>();
        String[] names = beanFactory.getBeanNamesForType(PointcutAdvisor.class);
        for (String name : names) {
            PointcutAdvisor o = beanFactory.getBean(name, PointcutAdvisor.class);
            advisors.add(o);
        }
        return Proxy.newProxyInstance(MyAop.class.getClassLoader(), new Class[]{IUserService.class}, new MyInvocation(bean, advisors));
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ListableBeanFactory) beanFactory;
    }
}
