package ru.eugene.java.learn.structure.bridge;

public class TV implements Device {
    private boolean enable;

    @Override
    public void on() {
        enable = true;
        System.out.println("on TV");
    }

    @Override
    public void off() {
        enable = false;
        System.out.println("off TV");
    }

    @Override
    public boolean isEnable() {
        return enable;
    }
}
