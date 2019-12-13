package ru.eugene.java.learn.generics.data;

public class Vehicle {
    private String number;

    public Vehicle(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "number='" + number + '\'' +
                '}';
    }
}
