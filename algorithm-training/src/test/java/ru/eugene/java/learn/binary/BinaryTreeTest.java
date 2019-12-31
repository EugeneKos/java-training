package ru.eugene.java.learn.binary;

import org.junit.Test;

public class BinaryTreeTest {
    @Test
    public void putTest(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.put(13);
        binaryTree.put(6);
        binaryTree.put(8);
        binaryTree.put(2);
        binaryTree.put(10);
        binaryTree.put(3);
        binaryTree.put(15);
        binaryTree.put(16);
        binaryTree.put(17);
        binaryTree.put(18);
        binaryTree.put(30);
        binaryTree.put(20);
        System.out.println(binaryTree);
    }
}