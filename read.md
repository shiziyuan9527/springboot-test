@SpringBootApplication
 - @EnableAutoConfiguration
    - @AutoConfigurationPackage
      - @Import({Registrar.class}) 加载该注解标注的类（启动类）所在包下的所有bean
    - @Import({AutoConfigurationImportSelector.class})导入AutoConfigurationImportSelector， 在此类中默认加载了所有spring-boot-autoconfigure-2.7.3.jar下META-INF/spring/ org.springframework.boot.autoconfigure.AutoConfiguration.imports
      文件中的所有声明的bean，具体是否生效还需要看是否引入了对应的类，用条件装配进行控制。
      例如 @ConditionalOnClass({Advice.class})，有Advice类时，加载AopAutoConfiguration Bean
