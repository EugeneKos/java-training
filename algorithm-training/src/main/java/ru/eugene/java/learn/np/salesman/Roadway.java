package ru.eugene.java.learn.np.salesman;

import java.util.Objects;

public class Roadway {
    private City fromCity;
    private City toCity;

    private int travelTime;

    public Roadway(City fromCity, City toCity, int travelTime) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.travelTime = travelTime;
    }

    public City getFromCity() {
        return fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roadway roadway = (Roadway) o;
        return travelTime == roadway.travelTime &&
                Objects.equals(fromCity, roadway.fromCity) &&
                Objects.equals(toCity, roadway.toCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromCity, toCity, travelTime);
    }
}
