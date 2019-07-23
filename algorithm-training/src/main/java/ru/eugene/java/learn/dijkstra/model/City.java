package ru.eugene.java.learn.dijkstra.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    private String name;
    private int distance;

    private List<City> path;

    public City(String name) {
        this.name = name;
        this.distance = Integer.MAX_VALUE;
        this.path = new ArrayList<>();
        this.path.add(this);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<City> getPath() {
        return path;
    }

    public void setPath(List<City> path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "City: " + name;
    }
}
