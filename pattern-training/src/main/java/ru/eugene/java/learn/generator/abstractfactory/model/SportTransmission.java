package ru.eugene.java.learn.generator.abstractfactory.model;

public class SportTransmission implements Transmission {
    @Override
    public void checkTransmission() {
        System.out.println("check sport transmission");
    }
}
