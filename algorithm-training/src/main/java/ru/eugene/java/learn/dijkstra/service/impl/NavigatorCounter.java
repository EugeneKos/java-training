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
    private Set<City> visitedCity = new HashSet<>();
    private List<Roadway> unconsideredRoadways = new ArrayList<>();

    @Override
    public List<City> getShortestPath(City from, City to) {
        unconsideredRoadways.addAll(DijkstraUtils.getRoadwaysByFromCity(roadways, from));
        while (!unconsideredRoadways.isEmpty()) {
            Roadway shortestRoadway = getShortestRoadway(unconsideredRoadways);
            unconsideredRoadways.remove(shortestRoadway);
            City fromCity = shortestRoadway.getFromCity();
            City toCity = shortestRoadway.getToCity();
            if(!visitedCity.contains(toCity)){
                int fullDistance = fromCity.getDistance() + shortestRoadway.getDistance();
                if(fullDistance < toCity.getDistance()){
                    toCity.setDistance(fullDistance);
                    List<City> path = new ArrayList<>(fromCity.getPath());
                    path.add(toCity);
                    toCity.setPath(path);
                }
                unconsideredRoadways.addAll(DijkstraUtils.getRoadwaysByFromCity(roadways, toCity));
            }
            visitedCity.add(fromCity);
        }
        return to.getPath();
    }

    private Roadway getShortestRoadway(List<Roadway> roadways) {
        Roadway shortestRoadway = null;
        int minDistance = Integer.MAX_VALUE;
        for (Roadway roadway : roadways) {
            int distance = roadway.getDistance();
            if (distance < minDistance) {
                minDistance = distance;
                shortestRoadway = roadway;
            }
        }
        return shortestRoadway;
    }
}
