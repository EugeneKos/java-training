package ru.eugene.java.learn.graphs.dijkstra.service.impl;

import ru.eugene.java.learn.graphs.dijkstra.model.Node;
import ru.eugene.java.learn.graphs.dijkstra.service.NodeService;

import java.util.*;

public class NodeServiceImpl implements NodeService {
    private Set<Node> nodesToVisit = new HashSet<>();
    private Set<Node> visitedNodes = new HashSet<>();

    @Override
    public List<Node> getShortestPath(Node begin, Node end) {
        nodesToVisit.add(begin);
        while (!nodesToVisit.isEmpty()){
            Node nodeWithMinWeight = getNodeWithMinWeight();
            nodesToVisit.remove(nodeWithMinWeight);
            Map<Node, Integer> neighbors = nodeWithMinWeight.getNeighbors();
            for (Node node : neighbors.keySet()){
                if(!visitedNodes.contains(node)){
                    int newWeight = nodeWithMinWeight.getWeight() + neighbors.get(node);
                    if(newWeight < node.getWeight()){
                        node.setWeight(newWeight);
                        node.setParent(nodeWithMinWeight);
                    }
                }
                nodesToVisit.add(node);
            }
            visitedNodes.add(nodeWithMinWeight);
        }
        return getPath(end);
    }

    private Node getNodeWithMinWeight(){
        int minWeight = Integer.MAX_VALUE;
        Node nodeWithMinWeight = null;
        for (Node node : nodesToVisit){
            if(node.getWeight() < minWeight){
                minWeight = node.getWeight();
                nodeWithMinWeight = node;
            }
        }
        return nodeWithMinWeight;
    }

    private List<Node> getPath(Node node){
        LinkedList<Node> path = new LinkedList<>();
        path.add(node);
        addParentInPath(node, path);
        return path;
    }

    private void addParentInPath(Node node, LinkedList<Node> path){
        if(node.getParent() == null){
            return;
        }
        Node parent = node.getParent();
        path.addFirst(parent);
        addParentInPath(parent, path);
    }
}
