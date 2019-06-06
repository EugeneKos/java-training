package ru.eugene.java.learn.config;

import org.springframework.context.annotation.*;
import ru.eugene.java.learn.data.Car;
import ru.eugene.java.learn.data.CarColor;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "ru.eugene.java.learn")
public class SpringConfiguration {
    @Bean
    @Scope(value = "prototype")
    public CarColor carColor() {
        CarColor carColor = new CarColor();
        carColor.setColor(new Color(new Random().nextInt(255),
                new Random().nextInt(255),
                new Random().nextInt(255)));

        return carColor;
    }

    @Bean
    public Car car(){
        Car car = new Car() {
            @Override
            public CarColor getCarColor() {
                return carColor();
            }
        };
        return car;
    }
}
