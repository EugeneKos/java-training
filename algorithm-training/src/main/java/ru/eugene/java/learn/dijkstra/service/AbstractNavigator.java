package ru.eugene.java.learn.dijkstra.service;

import ru.eugene.java.learn.dijkstra.model.City;
import ru.eugene.java.learn.dijkstra.model.Roadway;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNavigator implements Navigator {
    protected List<Roadway> roadways = new ArrayList<>();

    @Override
    public void addRoadway(City from, City to, int distance, boolean twoSided){
        if (twoSided) {
            roadways.add(new Roadway(from, to, distance));
            roadways.add(new Roadway(to, from, distance));
        } else {
            roadways.add(new Roadway(from, to, distance));
        }
    }
}
