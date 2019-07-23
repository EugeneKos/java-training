package ru.eugene.java.learn.dijkstra.service;

import org.junit.Assert;
import org.junit.Test;
import ru.eugene.java.learn.dijkstra.model.City;
import ru.eugene.java.learn.dijkstra.service.impl.NavigatorCounter;
import ru.eugene.java.learn.dijkstra.service.impl.NavigatorRecursion;

import java.util.List;

public class NavigatorTest {
    private City a = new City("A");
    private City b = new City("B");
    private City c = new City("C");
    private City d = new City("D");
    private City e = new City("E");
    private City f = new City("F");

    @Test
    public void testNavigator(){
        Navigator navigatorCounter = createNavigatorCounter();
        List<City> navigatorCounterPath = navigatorCounter.getShortestPath(a, f);

        Navigator navigatorRecursion = createNavigatorRecursion();
        List<City> navigatorRecursionPath = navigatorRecursion.getShortestPath(a, f);

        Assert.assertEquals("Compare Roadways", navigatorCounterPath, navigatorRecursionPath);

        System.out.println("Roadway counter: " + navigatorCounterPath);
        System.out.println("Roadway recursion: " + navigatorRecursionPath);
        System.out.println("Roadway distance: " + f.getDistance());
    }

    private Navigator createNavigatorCounter(){
        Navigator navigator = new NavigatorCounter();
        addRoadways(navigator);
        return navigator;
    }

    private Navigator createNavigatorRecursion(){
        Navigator navigator = new NavigatorRecursion();
        addRoadways(navigator);
        return navigator;
    }

    private void addRoadways(Navigator navigator){
        navigator.addRoadway(a, b, 3, true);
        navigator.addRoadway(a, c, 1, true);
        navigator.addRoadway(b, c, 1, true);
        navigator.addRoadway(b, d, 4, true);
        navigator.addRoadway(c, d, 8, true);
        navigator.addRoadway(c, e, 15, true);
        navigator.addRoadway(d, e, 7, true);
        navigator.addRoadway(d, f, 8, true);
        navigator.addRoadway(e, f, 4, true);
    }

}