package ru.eugene.java.learn.graphs.dijkstra.service.impl;

import ru.eugene.java.learn.graphs.dijkstra.service.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class DijkstraImpl implements Dijkstra {
    @Override
    public int dijkstra(int[][] graph, int target) {
        if (target >= graph.length) {
            return -1;
        }
        int[] pointsWeight = initPointsWeight(graph.length);
        List<Integer>[] history = initHistoryPath(graph.length);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(graph[i][j] != 0 && graph[i][j] != -1){
                    if (pointsWeight[i] + graph[i][j] < pointsWeight[j]){
                        pointsWeight[j] = pointsWeight[i] + graph[i][j];
                        history[j] = new ArrayList<>();
                        history[j].addAll(history[i]);
                        history[j].add(j);
                    }
                }
            }
        }
        System.out.println("points weight: " + Arrays.toString(pointsWeight));
        System.out.println("path : " + history[target]);

        return pointsWeight[target];
    }

    private int[] initPointsWeight(int length){
        int[] path = new int[length];
        for (int i = 1; i < length; i++) {
            path[i] = Integer.MAX_VALUE;
        }
        return path;
    }

    private List<Integer>[] initHistoryPath(int length){
        List<Integer>[] history = new List[length];
        for (int i = 0; i < length; i++) {
            history[i] = new ArrayList<>();
            history[i].add(i);
        }
        return history;
    }
}
