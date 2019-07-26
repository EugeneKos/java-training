package ru.eugene.java.learn.recursion;

import java.util.List;

public class RecursionImpl implements Recursion {
    @Override
    public int factorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorial(n - 1);
    }

    @Override
    public int sum(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return list.remove(0) + sum(list);
    }

    @Override
    public int getNumElements(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        if (list.size() == 1) {
            return 1;
        }
        list.remove(0);
        return 1 + getNumElements(list);
    }

    @Override
    public int getMinSideSquare(int length, int width) {
        if (length == width) {
            return length;
        }
        if (length > width) {
            length = length - width;
            return getMinSideSquare(length, width);
        } else {
            width = width - length;
            return getMinSideSquare(length, width);
        }
    }
}
