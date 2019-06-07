package ru.eugene.java.learn.structure.bridge;

public class Radio implements Device {
    private boolean enable;

    @Override
    public void on() {
        enable = true;
        System.out.println("on radio");
    }

    @Override
    public void off() {
        enable = false;
        System.out.println("off radio");
    }

    @Override
    public boolean isEnable() {
        return false;
    }
}
