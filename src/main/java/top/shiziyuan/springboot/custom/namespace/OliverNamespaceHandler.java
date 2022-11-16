package top.shiziyuan.springboot.custom.namespace;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class OliverNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
