package ru.eugene.java.learn.dijkstra;

import ru.eugene.java.learn.dijkstra.model.City;
import ru.eugene.java.learn.dijkstra.service.Navigator;

public class NavigatorApp {
    public static void main(String[] args) {
        City a = new City("A", Integer.MAX_VALUE);
        City b = new City("B", Integer.MAX_VALUE);
        City c = new City("C", Integer.MAX_VALUE);
        City d = new City("D", Integer.MAX_VALUE);
        City e = new City("E", Integer.MAX_VALUE);
        City f = new City("F", 0);

        Navigator navigator = new Navigator();

        navigator.addRoadway(a, b, 3, true);
        navigator.addRoadway(a, c, 4, true);
        navigator.addRoadway(b, d, 5, true);
        navigator.addRoadway(c, d, 7, true);
        navigator.addRoadway(c, e, 10, true);
        navigator.addRoadway(d, e, 2, true);
        navigator.addRoadway(d, f, 8, true);
        navigator.addRoadway(e, f, 4, true);

        System.out.println("Roadway: " + navigator.getShortestPath(f, a));
        System.out.println("Roadway distance: " + a.getDistance());
    }
}
