package ru.eugene.java.learn.generator.abstractfactory.model;

public class SportEngine implements Engine {
    @Override
    public void checkEngine() {
        System.out.println("check sport engine");
    }
}
