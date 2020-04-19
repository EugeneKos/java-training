package ru.eugene.java.learn.generics;

import org.junit.Test;

import static ru.eugene.java.learn.generics.GenericConsumerProducer.Child;
import static ru.eugene.java.learn.generics.GenericConsumerProducer.Parent;
import static ru.eugene.java.learn.generics.GenericConsumerProducer.Producer;
import static ru.eugene.java.learn.generics.GenericConsumerProducer.Consumer;

public class GenericConsumerProducerTest {
    @Test
    public void genericConsumerProducerTest(){
        GenericConsumerProducer genericConsumerProducer = new GenericConsumerProducer();

        Producer<Child> childProducer = () -> new Child("eugene_1");
        Consumer<Parent> parentConsumer = parent -> System.out.println(parent.getName());

        genericConsumerProducer.setProducer(childProducer);
        genericConsumerProducer.setConsumer(parentConsumer, new Child("eugene_2"));
    }
}