package ru.eugene.java.learn.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public abstract class Car {
    private String mark;
    private String model;
    private CarColor carColor;

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

    public abstract CarColor getCarColor();

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }
}
