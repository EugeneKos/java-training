package ru.eugene.java.learn.graphs.dijkstra.service.impl;

import ru.eugene.java.learn.graphs.dijkstra.model.City;
import ru.eugene.java.learn.graphs.dijkstra.model.Roadway;
import ru.eugene.java.learn.graphs.dijkstra.service.AbstractNavigator;
import ru.eugene.java.learn.graphs.dijkstra.util.DijkstraUtils;

import java.util.ArrayList;
import java.util.List;

public class NavigatorRecursion extends AbstractNavigator {
    @Override
    public List<City> getShortestPath(City from, City to){
        from.setDistance(0);
        calculateRoadwaysForCity(from);
        return to.getPath();
    }

    private void calculateRoadwaysForCity(City from){
        List<Roadway> roadwaysByFromCity = DijkstraUtils.getRoadwaysByFromCity(roadways, from);
        for (Roadway roadway : roadwaysByFromCity){
            City fromCity = roadway.getFromCity();
            City toCity = roadway.getToCity();
            if(roadway.getDistance() < 0){
                throw new IllegalArgumentException("Negative routes are not allowed !");
            }
            int currentDistance = fromCity.getDistance() + roadway.getDistance();
            if(currentDistance < toCity.getDistance()){
                toCity.setDistance(currentDistance);
                List<City> currentPathToCity = new ArrayList<>(fromCity.getPath());
                currentPathToCity.add(toCity);
                toCity.setPath(currentPathToCity);
                calculateRoadwaysForCity(toCity);
            }
        }
    }
}
