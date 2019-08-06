package ru.eugene.java.learn.graphs.search.wide;

import java.util.*;

public class Vertex {
    private String name;

    private Set<Vertex> neighbors = new HashSet<>();

    private List<Vertex> path = new ArrayList<>();

    public Vertex(String name) {
        this.name = name;
        path.add(this);
    }

    public void addNeighbor(Vertex vertex){
        neighbors.add(vertex);
    }

    public String getName() {
        return name;
    }

    public Set<Vertex> getNeighbors() {
        return neighbors;
    }

    public List<Vertex> getPath() {
        return path;
    }

    public void setPath(List<Vertex> path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
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
