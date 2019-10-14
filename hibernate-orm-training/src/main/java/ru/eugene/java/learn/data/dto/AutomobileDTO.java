package ru.eugene.java.learn.data.dto;

import java.util.Objects;

public class AutomobileDTO {
    private Long id;
    private String mark;
    private String model;
    private String stateNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutomobileDTO that = (AutomobileDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(model, that.model) &&
                Objects.equals(stateNumber, that.stateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, stateNumber);
    }
}
