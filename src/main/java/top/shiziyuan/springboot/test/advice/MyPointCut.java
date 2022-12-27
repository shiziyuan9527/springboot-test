package top.shiziyuan.springboot.test.advice;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

public class MyPointCut implements Pointcut {
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                if (UserService.class.isAssignableFrom(clazz)) {
                    return true;
                }
                return false;
            }
        };
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                if (method.getName().equals("test")) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean isRuntime() {
                return true;
            }

            @Override
            public boolean matches(Method method, Class<?> targetClass, Object... args) {
                return matches(method, targetClass);
            }
        };
    }
}
