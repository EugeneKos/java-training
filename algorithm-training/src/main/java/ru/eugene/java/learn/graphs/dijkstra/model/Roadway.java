package ru.eugene.java.learn.graphs.dijkstra.model;

public class Roadway {
    private City fromCity;
    private City toCity;
    private int distance;

    public Roadway(City fromCity, City toCity, int distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    public City getFromCity() {
        return fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public int getDistance() {
        return distance;
    }
}
