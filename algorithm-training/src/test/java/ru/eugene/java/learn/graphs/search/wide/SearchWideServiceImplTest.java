package ru.eugene.java.learn.graphs.search.wide;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchWideServiceImplTest {
    @Test
    public void searchWideTest(){
        Vertex you = new Vertex("you");
        Vertex john = new Vertex("John");
        Vertex jack = new Vertex("Jack");
        Vertex helen = new Vertex("Helen");
        Vertex natalie = new Vertex("Natalie");

        you.addNeighbor(john);

        john.addNeighbor(jack);
        john.addNeighbor(helen);

        jack.addNeighbor(natalie);

        SearchWideService searchWideService = new SearchWideServiceImpl();
        boolean search = searchWideService.searchWide(you, natalie);

        Assert.assertTrue(search);
    }

    @Test
    public void shortestPathTest(){
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");

        a.addNeighbor(b);
        a.addNeighbor(c);

        b.addNeighbor(d);
        b.addNeighbor(e);

        c.addNeighbor(f);

        f.addNeighbor(g);

        SearchWideService searchWideService = new SearchWideServiceImpl();
        boolean search = searchWideService.searchWide(a, g);

        Assert.assertTrue(search);

        System.out.println(g.getPath());

        Assert.assertEquals("compare path", new ArrayList<>(Arrays.asList(a, c, f, g)), g.getPath());
    }

}