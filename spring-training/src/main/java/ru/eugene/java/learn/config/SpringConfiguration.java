package ru.eugene.java.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import ru.eugene.java.learn.data.Car;

import java.awt.Color;
import java.util.Random;

@Configuration
@Import({SpringConfig1.class, SpringConfig2.class})
public class SpringConfiguration {
    @Bean
    @Scope("prototype")
    public Color color(){
        return new Color(new Random()
                .nextInt(255), new Random()
                .nextInt(255), new Random()
                .nextInt(255));
    }

    @Bean
    public Car car(){
        return new Car() {
            @Override
            public Color getColor() {
                return color();
            }
        };
    }
}
