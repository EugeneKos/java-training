package ru.eugene.java.learn.dijkstra.service;

import ru.eugene.java.learn.dijkstra.model.City;

import java.util.List;

public interface Navigator {
    void addRoadway(City from, City to, int distance, boolean twoSided);

    List<City> getShortestPath(City from, City to);
}
