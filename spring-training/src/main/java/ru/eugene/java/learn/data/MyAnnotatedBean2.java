package ru.eugene.java.learn.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyAnnotatedBean2 {
    private MyAnnotatedBean1 myAnnotatedBean1;

    @Autowired
    public MyAnnotatedBean2(MyAnnotatedBean1 myAnnotatedBean1) {
        this.myAnnotatedBean1 = myAnnotatedBean1;
    }
}
