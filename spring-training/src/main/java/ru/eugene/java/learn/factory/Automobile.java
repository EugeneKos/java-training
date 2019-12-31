package ru.eugene.java.learn.factory;

public class Automobile implements Transport {
    @Override
    public void motion() {
        System.out.println("automobile motion");
    }
}
