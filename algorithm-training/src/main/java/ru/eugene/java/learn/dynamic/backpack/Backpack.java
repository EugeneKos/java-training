package ru.eugene.java.learn.dynamic.backpack;

import java.util.Objects;

public class Backpack {
    private int capacity;

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backpack backpack = (Backpack) o;
        return capacity == backpack.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity);
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "capacity=" + capacity +
                '}';
    }
}
