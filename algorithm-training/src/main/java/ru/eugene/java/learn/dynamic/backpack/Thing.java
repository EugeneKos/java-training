package ru.eugene.java.learn.dynamic.backpack;

import java.util.Objects;

public class Thing {
    private String name;
    private int weight;
    private int coast;

    public Thing(String name, int weight, int coast) {
        this.name = name;
        this.weight = weight;
        this.coast = coast;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCoast() {
        return coast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return weight == thing.weight &&
                coast == thing.coast &&
                Objects.equals(name, thing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, coast);
    }

    @Override
    public String toString() {
        return "Thing{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", coast=" + coast +
                '}';
    }
}
