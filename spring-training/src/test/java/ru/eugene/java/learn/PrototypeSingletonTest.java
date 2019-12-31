package ru.eugene.java.learn;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Car;

public class PrototypeSingletonTest {
    @Test
    public void prototypeSingletonTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Car car = context.getBean(Car.class);
        for (int i = 0; i < 100; i++) {
            System.out.println(car.getColor().toString());
        }
    }
}
