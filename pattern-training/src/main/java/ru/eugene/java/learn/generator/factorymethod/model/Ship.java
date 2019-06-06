package ru.eugene.java.learn.generator.factorymethod.model;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка на морском судне");
    }
}
