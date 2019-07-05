package ru.eugene.java.learn.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.eugene.java.learn.validate.impl.PassportValidator;

@Configuration
@ComponentScan(basePackageClasses = {PassportValidator.class})
public class TestSpringConfiguration {
}
