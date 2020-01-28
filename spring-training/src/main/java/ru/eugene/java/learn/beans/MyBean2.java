package ru.eugene.java.learn.beans;

public class MyBean2 {
    private MyBean1 myBean1;

    public MyBean2(MyBean1 myBean1) {
        this.myBean1 = myBean1;
    }

    public void do2(){
        System.out.println("my bean 2 do 2");
        myBean1.do1();
    }
}
