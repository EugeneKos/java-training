package ru.eugene.java.learn.generator.factorymethod.model;

public class Automobile implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка на автомобиле");
    }
}
