package ru.eugene.java.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "ru.eugene.java.learn")
@Import({DataConfiguration.class})
public class SpringConfiguration {

}
