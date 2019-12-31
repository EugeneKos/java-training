package ru.eugene.java.learn;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.eugene.java.learn.factory.Automobile;
import ru.eugene.java.learn.factory.Transport;

public class SpringFactoryMethodTest {
    @Test
    public void springFactoryMethodTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:application-context.xml"
        );

        Transport transport = applicationContext.getBean(Automobile.class);
        transport.motion();
    }
}
