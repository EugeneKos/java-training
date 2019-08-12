package ru.eugene.java.learn.graphs.dijkstra.service;

import ru.eugene.java.learn.graphs.dijkstra.model.Node;

import java.util.List;

public interface NodeService {
    List<Node> getShortestPath(Node begin, Node end);
}
