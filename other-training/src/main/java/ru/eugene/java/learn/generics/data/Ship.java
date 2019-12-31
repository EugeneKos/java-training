package ru.eugene.java.learn.generics.data;

public class Ship extends Vehicle {
    private String captainName;

    public Ship(String number, String captainName) {
        super(number);
        this.captainName = captainName;
    }

    public String getCaptainName() {
        return captainName;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "captainName='" + captainName + '\'' +
                '}';
    }
}
