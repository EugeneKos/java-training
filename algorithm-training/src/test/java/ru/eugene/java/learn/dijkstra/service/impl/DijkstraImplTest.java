package ru.eugene.java.learn.dijkstra.service.impl;

import org.junit.Test;
import ru.eugene.java.learn.dijkstra.service.Dijkstra;

import static org.junit.Assert.*;

public class DijkstraImplTest {
    @Test
    public void testDijkstra(){
        /*int[][] graph = {
                {0, 3, 4, -1, -1, -1},
                {3, 0, -1, 5, -1, -1},
                {4, -5, 0, 7, 10, -1},
                {-1, 5, 7, 0, 2, 8},
                {-1, -1, 10, 2, 0, 4},
                {-1, -1, -1, 8, 4, 0},
        };*/

        int[][] graph = {
                { 0,  3, 1, -1, -1},
                { 3,  0, 1,  4, -1},
                { 1,  1, 0,  8,  15},
                {-1,  4, 8,  0,  7},
                {-1, -1, 15,  7,  0},
        };

        Dijkstra dijkstra = new DijkstraImpl();

        int shortestPath = dijkstra.dijkstra(graph, 4);
        System.out.println("shortest path: " + shortestPath);
    }
}