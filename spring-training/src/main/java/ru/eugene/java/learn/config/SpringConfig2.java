package ru.eugene.java.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.eugene.java.learn.data.MyAnnotatedBean1;
import ru.eugene.java.learn.data.MyAnnotatedBean2;

@Configuration
public class SpringConfig2 {
    @Bean
    public MyAnnotatedBean2 myAnnotatedBean2(MyAnnotatedBean1 myAnnotatedBean1){
        return new MyAnnotatedBean2(myAnnotatedBean1);
    }
}
