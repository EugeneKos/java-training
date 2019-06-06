package ru.eugene.java.learn.generator.prototype;

import java.util.Objects;

/**
 * Смысл паттерна prototype в написание метода clone в котором объект создаст сам себя и
 * запишет значение своих полей в новый объект
 */
public class BmwCar extends Car {
    private String turbo;

    public BmwCar(String mark, String model, String turbo) {
        super(mark, model);
        this.turbo = turbo;
    }

    /**
     * Логика копирования объекта
     * @param bmwCar
     */
    private BmwCar(BmwCar bmwCar) {
        /*super(bmwCar.mark, bmwCar.model);
        this.turbo = bmwCar.turbo;*/
        this(bmwCar.mark, bmwCar.model, bmwCar.turbo);
    }

    public String getTurbo() {
        return turbo;
    }

    public void setTurbo(String turbo) {
        this.turbo = turbo;
    }

    @Override
    public BmwCar cloneCar() {
        return new BmwCar(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BmwCar bmwCar = (BmwCar) o;
        return Objects.equals(turbo, bmwCar.turbo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), turbo);
    }
}
