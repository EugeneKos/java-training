package ru.eugene.java.learn;

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, 16, -1, -1, -1},
                {3, 0, -1, 5, -1, -1},
                {16, -1, 0, 7, 10, -1},
                {-1, 5, 7, 0, 5, 8},
                {-1, -1, 10, 5, 0, 4},
                {-1, -1, -1, 8, 4, 0},
        };

        int shortestPath = dijkstra(graph, 0, 2);
        System.out.println("shortest path: " + shortestPath);
    }

    private static int dijkstra(int[][] graph, int begin, int finish) {
        if (begin >= graph.length || finish >= graph.length) {
            return -2;
        }
        int[] path = initPath(begin, graph.length);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(graph[i][j] != 0 && graph[i][j] != -1){
                    if (path[i] + graph[i][j] < path[j]){
                        path[j] = path[i] + graph[i][j];
                    }
                }
            }
        }
        System.out.println("path: " + Arrays.toString(path));

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
}
