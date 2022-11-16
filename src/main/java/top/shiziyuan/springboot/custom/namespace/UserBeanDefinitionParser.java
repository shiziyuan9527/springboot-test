package top.shiziyuan.springboot.custom.namespace;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;
import top.shiziyuan.springboot.domain.User;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        int age = Integer.parseInt(element.getAttribute("age"));
        String name = element.getAttribute("name");
        builder.addPropertyValue("age", age);
        builder.addPropertyValue("name", name);
    }
}
