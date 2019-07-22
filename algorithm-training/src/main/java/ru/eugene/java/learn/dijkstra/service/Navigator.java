package ru.eugene.java.learn.dijkstra.service;

import ru.eugene.java.learn.dijkstra.model.City;
import ru.eugene.java.learn.dijkstra.model.Roadway;

import java.util.ArrayList;
import java.util.List;

public class Navigator {
    private List<Roadway> roadways = new ArrayList<>();

    public void addRoadway(City from, City to, int distance, boolean twoSided){
        if (twoSided) {
            roadways.add(new Roadway(from, to, distance));
            roadways.add(new Roadway(to, from, distance));
        } else {
            roadways.add(new Roadway(from, to, distance));
        }
    }

    public List<City> getShortestPath(City from, City to){
        calculateRoadwaysForCity(from);
        return to.getPath();
    }

    private void calculateRoadwaysForCity(City from){
        List<Roadway> roadwaysByFromCity = getRoadwaysByFromCity(from);
        for (Roadway roadway : roadwaysByFromCity){
            City toCity = roadway.getToCity();
            City fromCity = roadway.getFromCity();
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

    private List<Roadway> getRoadwaysByFromCity(City from){
        List<Roadway> roadwaysByFromCity = new ArrayList<>();
        for (Roadway roadway : roadways){
            if(from.equals(roadway.getFromCity())){
                roadwaysByFromCity.add(roadway);
            }
        }
        return roadwaysByFromCity;
    }
}
