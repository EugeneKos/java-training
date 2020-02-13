package ru.eugene.java.learn.beans;

public class MyBean1 {
    private String name;

    public MyBean1(String name) {
        this.name = name;
    }

    public void do1(){
        System.out.println("my bean 1 do 1. Name is " + name);
    }
}
