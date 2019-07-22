package ru.eugene.java.learn.dijkstra.util;

import ru.eugene.java.learn.dijkstra.model.City;
import ru.eugene.java.learn.dijkstra.model.Roadway;

import java.util.ArrayList;
import java.util.List;

public final class DijkstraUtils {
    private DijkstraUtils(){}

    public static List<Roadway> getRoadwaysByFromCity(List<Roadway> roadways, City from){
        List<Roadway> roadwaysByFromCity = new ArrayList<>();
        for (Roadway roadway : roadways){
            if(from.equals(roadway.getFromCity())){
                roadwaysByFromCity.add(roadway);
            }
        }
        return roadwaysByFromCity;
    }
}
