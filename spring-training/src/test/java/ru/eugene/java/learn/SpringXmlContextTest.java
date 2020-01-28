package ru.eugene.java.learn;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.eugene.java.learn.beans.MyBean2;

public class SpringXmlContextTest {
    @Test
    public void multiplyContextTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:application-context.xml"
        );

        MyBean2 myBean2 = applicationContext.getBean(MyBean2.class);
        myBean2.do2();
    }
}
