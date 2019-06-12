package ru.eugene.java.learn.behaviour.iterator;

import java.util.Iterator;

public class CustomList implements Iterable {


    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
