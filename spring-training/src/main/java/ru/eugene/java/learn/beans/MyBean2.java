package ru.eugene.java.learn.beans;

import ru.eugene.java.learn.annotation.InjectRandomInt;

public class MyBean2 {
    @InjectRandomInt(min = 20, max = 100)
    private int random;

    private MyBean1 myBean1;

    public MyBean2(MyBean1 myBean1) {
        this.myBean1 = myBean1;
    }

    public void do2(){
        System.out.println("my bean 2 do 2. Random = " + random);
        myBean1.do1();
    }
}
