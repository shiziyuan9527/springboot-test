package top.shiziyuan.springboot.test.advice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyInvocation implements InvocationHandler {

    private Object target;
    private final List<PointcutAdvisor> before = new ArrayList<>();
    private final List<PointcutAdvisor> after = new ArrayList<>();

    // ? No qualifying bean of type 'java.lang.Object' available: expected single matching bean but found 19
    public MyInvocation() {

    }

    public MyInvocation(Object bean, List<PointcutAdvisor> advisors) {
        this.target = bean;
        this.setAdvisors(advisors);
    }

    private void setAdvisors(List<PointcutAdvisor> advisors) {
        for (PointcutAdvisor p : advisors) {
            if (p.getAdvice() instanceof MethodBeforeAdvice) {
                before.add(p);
            }
            if (p.getAdvice() instanceof AfterReturningAdvice) {
                after.add(p);
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (PointcutAdvisor b : before) {
            if (b.getPointcut().getClassFilter().matches(target.getClass())) {
                if (b.getPointcut().getMethodMatcher().matches(method, target.getClass())) {
                    ((MethodBeforeAdvice)b.getAdvice()).before(method, args, target);
                }
            }
        }
        Object res = method.invoke(target, args);
        for (PointcutAdvisor a : after) {
            if (a.getPointcut().getClassFilter().matches(target.getClass())) {
                if (a.getPointcut().getMethodMatcher().matches(method, target.getClass())) {
                    ((AfterReturningAdvice)a.getAdvice()).afterReturning(res, method, args, target);
                }
            }
        }
        return res;
    }
}
