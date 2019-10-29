package ru.eugene.java.learn.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "ru.eugene.java.learn")
@Import({DataConfiguration.class})
public class SpringConfiguration {
    @Bean
    public Mapper mapper(){
        return new DozerBeanMapper();
    }
}
