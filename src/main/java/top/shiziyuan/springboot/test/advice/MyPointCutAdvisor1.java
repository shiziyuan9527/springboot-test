package top.shiziyuan.springboot.test.advice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class MyPointCutAdvisor1 implements PointcutAdvisor, BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
    @Override
    public Pointcut getPointcut() {
        return new MyPointCut();
    }

    @Override
    public Advice getAdvice() {
        return new MyAfter();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }


}
