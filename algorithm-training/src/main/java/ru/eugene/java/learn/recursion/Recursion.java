package ru.eugene.java.learn.recursion;

import java.util.List;

public interface Recursion {
    int factorial(int n);

    int sum(List<Integer> list);

    int getNumElements(List<Integer> list);

    int getMinSideSquare(int length, int width);
}
