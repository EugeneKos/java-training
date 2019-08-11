package ru.eugene.java.learn.graphs.dijkstra.service.impl;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.eugene.java.learn.graphs.dijkstra.model.Node;
import ru.eugene.java.learn.graphs.dijkstra.service.NodeService;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NodeServiceImplTest {
    private NodeService nodeService;

    @Before
    public void init(){
        nodeService = new NodeServiceImpl();
    }

    @Test
    public void getShortestPathTest(){
        Node start = new Node("start", 0);
        Node a = new Node("A", Integer.MAX_VALUE);
        Node b = new Node("B", Integer.MAX_VALUE);
        Node finish = new Node("finish", Integer.MAX_VALUE);

        start.addNeighbour(a, 6);
        start.addNeighbour(b, 2);

        a.addNeighbour(finish, 1);

        b.addNeighbour(a, 3);
        b.addNeighbour(finish, 5);

        List<Node> shortestPath = nodeService.getShortestPath(start, finish);
        System.out.println(shortestPath);

        List<Node> expectedShortestPath = new ArrayList<>(Arrays.asList(start, b, a, finish));

        Assert.assertEquals("compare shortest path", expectedShortestPath, shortestPath);
    }
}
