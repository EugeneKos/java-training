package ru.eugene.java.learn.graphs.tree;

import org.junit.Test;

public class TreeReverseTest {
    @Test
    public void reverseTest(){
        TreeReverse.Node root = new TreeReverse.Node("A",
                new TreeReverse.Node("B",
                        new TreeReverse.Node("C",
                                new TreeReverse.Node("D",
                                        new TreeReverse.Node("E",
                                                null)))));

        System.out.println(root);

        TreeReverse.Node reverse = TreeReverse.reverse(root);

        System.out.println(reverse);
    }
}