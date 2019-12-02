package ru.eugene.java.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataConfiguration.class})
public class DomainConfiguration {

}
