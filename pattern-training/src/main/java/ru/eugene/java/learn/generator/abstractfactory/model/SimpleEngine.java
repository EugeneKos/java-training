package ru.eugene.java.learn.generator.abstractfactory.model;

public class SimpleEngine implements Engine {
    @Override
    public void checkEngine() {
        System.out.println("check simple engine");
    }
}
