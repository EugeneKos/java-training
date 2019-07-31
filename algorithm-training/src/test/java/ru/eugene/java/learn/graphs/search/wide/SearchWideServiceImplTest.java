package ru.eugene.java.learn.graphs.search.wide;

import org.junit.Assert;
import org.junit.Test;

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

}