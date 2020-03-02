package ru.eugene.java.learn.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class MyBean4 {
    @Autowired
    private MyBean3 myBean3;

    public void do4(){
        System.out.println("My bean 4 do 4");
        myBean3.do3();
    }
}
