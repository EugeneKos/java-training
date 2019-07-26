package ru.eugene.java.learn.model;

import java.util.Objects;

public class Cell {
    private int coordinateX;
    private int coordinateY;

    public Cell(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return coordinateX == cell.coordinateX &&
                coordinateY == cell.coordinateY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }
}
