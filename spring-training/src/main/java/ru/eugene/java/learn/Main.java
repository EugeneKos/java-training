package ru.eugene.java.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Car;
import ru.eugene.java.learn.data.CarColor;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Car car = context.getBean(Car.class);
        for (int i = 0; i < 100; i++) {
            //System.out.println(context.getBean(CarColor.class).getColor().toString());
            System.out.println(car.getCarColor().getColor().toString());
        }
    }
}
