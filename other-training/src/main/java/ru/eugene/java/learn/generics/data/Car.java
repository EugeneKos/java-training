package ru.eugene.java.learn.generics.data;

public class Car extends Vehicle {
    private int doorsAmount;

    public Car(String number, int doorsAmount) {
        super(number);
        this.doorsAmount = doorsAmount;
    }

    public int getDoorsAmount() {
        return doorsAmount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "doorsAmount=" + doorsAmount +
                '}';
    }
}
