package ru.eugene.java.learn.graphs.dijkstra.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Node {
    private String name;
    private int weight;

    private Map<Node, Integer> neighbors = new HashMap<>();

    private Node parent;

    public Node(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addNeighbour(Node neighbour, int weight){
        neighbors.put(neighbour, weight);
    }

    public Map<Node, Integer> getNeighbors() {
        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
