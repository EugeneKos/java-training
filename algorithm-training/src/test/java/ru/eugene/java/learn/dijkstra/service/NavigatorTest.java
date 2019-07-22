package ru.eugene.java.learn.dijkstra.service;

import org.junit.Test;
import ru.eugene.java.learn.dijkstra.model.City;
import ru.eugene.java.learn.dijkstra.service.impl.NavigatorCounter;
import ru.eugene.java.learn.dijkstra.service.impl.NavigatorRecursion;

public class NavigatorTest {
    @Test
    public void testNavigatorRecursion(){
        City a = new City("A", 0);
        City b = new City("B", Integer.MAX_VALUE);
        City c = new City("C", Integer.MAX_VALUE);
        City d = new City("D", Integer.MAX_VALUE);
        City e = new City("E", Integer.MAX_VALUE);
        City f = new City("F", Integer.MAX_VALUE);

        Navigator navigator = new NavigatorCounter();

        navigator.addRoadway(a, b, 3, true);
        navigator.addRoadway(a, c, 1, true);
        navigator.addRoadway(b, c, 1, true);
        navigator.addRoadway(b, d, 4, true);
        navigator.addRoadway(c, d, 8, true);
        navigator.addRoadway(c, e, 15, true);
        navigator.addRoadway(d, e, 7, true);
        /*navigator.addRoadway(d, f, 8, true);
        navigator.addRoadway(e, f, 4, true);*/

        System.out.println("Roadway: " + navigator.getShortestPath(a, e));
        System.out.println("Roadway distance: " + e.getDistance());
    }

}