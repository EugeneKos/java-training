package ru.eugene.java.learn.dijkstra.service.impl;

import ru.eugene.java.learn.dijkstra.model.City;
import ru.eugene.java.learn.dijkstra.model.Roadway;
import ru.eugene.java.learn.dijkstra.service.AbstractNavigator;
import ru.eugene.java.learn.dijkstra.util.DijkstraUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NavigatorCounter extends AbstractNavigator {
    private Set<City> unvisitedCity = new HashSet<>();

    @Override
    public List<City> getShortestPath(City from, City to) {
        from.setDistance(0);
        unvisitedCity.add(from);
        while (!unvisitedCity.isEmpty()){
            City current = getShortestDistanceCity(unvisitedCity);
            unvisitedCity.remove(current);
            List<Roadway> roadways = DijkstraUtils.getRoadwaysByFromCity(super.roadways, current);
            roadways.forEach(this::calculateRoadway);
        }
        return to.getPath();
    }

    private void calculateRoadway(Roadway roadway){
        City fromCity = roadway.getFromCity();
        City toCity = roadway.getToCity();
        int distance = fromCity.getDistance() + roadway.getDistance();
        if(distance < toCity.getDistance()){
            toCity.setDistance(distance);
            List<City> path = new ArrayList<>(fromCity.getPath());
            path.add(toCity);
            toCity.setPath(path);
            unvisitedCity.add(toCity);
        }
    }

    private City getShortestDistanceCity(Set<City> cities){
        City shortestDistanceCity = null;
        int shortestDistance = Integer.MAX_VALUE;
        for (City city : cities){
            if(city.getDistance() < shortestDistance){
                shortestDistance = city.getDistance();
                shortestDistanceCity = city;
            }
        }
        return shortestDistanceCity;
    }
}
