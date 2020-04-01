package ru.eugene.java.learn;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.MyAnnotatedBean1;
import ru.eugene.java.learn.data.MyAnnotatedBean2;

public class SpringAnnotationContextTest {
    @Test
    public void annotationContextSpring(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        MyAnnotatedBean1 myAnnotatedBean1 = context.getBean(MyAnnotatedBean1.class);
        Assert.assertNotNull(myAnnotatedBean1);
        Assert.assertEquals("777-33-23", myAnnotatedBean1.getPhone());

        MyAnnotatedBean2 myAnnotatedBean2 = context.getBean(MyAnnotatedBean2.class);
        Assert.assertNotNull(myAnnotatedBean2);
    }
}
