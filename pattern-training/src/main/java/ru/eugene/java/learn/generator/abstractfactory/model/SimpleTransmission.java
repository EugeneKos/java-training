package ru.eugene.java.learn.generator.abstractfactory.model;

public class SimpleTransmission implements Transmission {
    @Override
    public void checkTransmission() {
        System.out.println("check simple transmission");
    }
}
