package ru.eugene.java.learn.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyObject implements Comparable<MyObject> {
    private int key;
    private String value;

    public MyObject(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(MyObject o) {
        int compare = Integer.compare(key, o.key);
        if(compare != 0){
            return compare;
        }

        compare = value.compareTo(o.value);
        if(compare != 0){
            return compare;
        }

        return 0;
    }

    @Override
    public String toString() {
        return key + " : " + value;
    }

    public static void main(String[] args) {
        List<MyObject> myObjects = new ArrayList<>(Arrays.asList(
              new MyObject(5, "a"),
              new MyObject(15, "b"),
              new MyObject(2, "c"),
              new MyObject(3, "d"),
              new MyObject(12, "e"),
              new MyObject(4, "f"),
              new MyObject(2, "g")
        ));

        System.out.println(myObjects);

        Collections.sort(myObjects);

        System.out.println(myObjects);

        MyObject[] objects = new MyObject[2];
        System.out.println(objects.getClass().getName());
    }
}
