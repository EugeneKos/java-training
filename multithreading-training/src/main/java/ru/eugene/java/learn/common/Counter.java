package ru.eugene.java.learn.common;

public class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public void decrement(){
        count--;
    }

    public int getCount() {
        return count;
    }
}
