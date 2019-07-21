package ru.eugene.java.learn.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, 4, -1, -1, -1},
                {3, 0, -1, 5, -1, -1},
                {4, -1, 0, 7, 10, -1},
                {-1, 5, 7, 0, 2, 8},
                {-1, -1, 10, 2, 0, 4},
                {-1, -1, -1, 8, 4, 0},
        };

        int shortestPath = dijkstra(graph, 0, 5);
        System.out.println("shortest path: " + shortestPath);
    }

    private static int dijkstra(int[][] graph, int begin, int finish) {
        if (begin >= graph.length || finish >= graph.length) {
            return -2;
        }
        int[] path = initPath(begin, graph.length);
        List<Integer>[] history = initHistoryPath(graph.length);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(graph[i][j] != 0 && graph[i][j] != -1){
                    if (path[i] + graph[i][j] < path[j]){
                        path[j] = path[i] + graph[i][j];
                        history[j] = new ArrayList<>();
                        history[j].addAll(history[i]);
                        history[j].add(j);
                    }
                }
            }
        }
        System.out.println("path length: " + Arrays.toString(path));
        System.out.println("path : " + history[finish]);

        return path[finish];
    }

    private static int[] initPath(int begin, int length){
        if(begin >= length){
            throw new IllegalArgumentException("begin value");
        }
        int[] path = new int[length];

        for (int i = 0; i < length; i++) {
            if(i != begin){
                path[i] = Integer.MAX_VALUE;
            }
        }

        return path;
    }

    private static List<Integer>[] initHistoryPath(int length){
        List<Integer>[] history = new List[length];
        for (int i = 0; i < length; i++) {
            history[i] = new ArrayList<>();
            //if(i == 0){
                history[i].add(i);
            //}
        }
        return history;
    }
}
