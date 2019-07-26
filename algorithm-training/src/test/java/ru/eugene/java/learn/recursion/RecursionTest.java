package ru.eugene.java.learn.recursion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RecursionTest {
    private Recursion recursion;

    @Before
    public void init(){
        recursion = new RecursionImpl();
    }

    @Test
    public void factorialTest(){
        int n = 5;
        int nFactorial = recursion.factorial(n);
        System.out.println("factorial " + n + " = " + nFactorial);
        Assert.assertEquals("compare factorial", 120, nFactorial);
    }

    @Test
    public void sumTest(){
        List<Integer> list = new LinkedList<>(Arrays.asList(2, 4, 6));
        int sum = recursion.sum(list);
        System.out.println("sum: " + sum);
        Assert.assertEquals("compare sum", 12, sum);
    }

    @Test
    public void getNumElementsTest(){
        List<Integer> list = new LinkedList<>(Arrays.asList(2, 4, 6));
        int numElements = recursion.getNumElements(list);
        System.out.println("elements num: " + numElements);
        Assert.assertEquals("compare elements num", 3, numElements);
    }

    @Test
    public void getMinSideSquareTest(){
        int minSideSquare = recursion.getMinSideSquare(1680, 640);
        System.out.println("min side square: " + minSideSquare);
        Assert.assertEquals(80, minSideSquare);
    }

}