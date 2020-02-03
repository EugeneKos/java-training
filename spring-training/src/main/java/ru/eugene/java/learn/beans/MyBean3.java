package ru.eugene.java.learn.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean3 {
    private final MyBean2 myBean2;

    @Autowired
    public MyBean3(MyBean2 myBean2) {
        this.myBean2 = myBean2;
    }

    public void do3(){
        System.out.println("my bean 3 do 3");
        myBean2.do2();
    }
}
