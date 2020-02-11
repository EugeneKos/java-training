package ru.eugene.java.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.eugene.java.learn.data.MyAnnotatedBean1;

@Configuration
public class SpringConfig1 {
    @Bean
    public MyAnnotatedBean1 myAnnotatedBean1(){
        return new MyAnnotatedBean1();
    }
}
