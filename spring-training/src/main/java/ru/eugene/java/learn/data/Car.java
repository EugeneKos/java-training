package ru.eugene.java.learn.data;

import java.awt.Color;

public abstract class Car {
    private String mark;
    private String model;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract Color getColor();
}
