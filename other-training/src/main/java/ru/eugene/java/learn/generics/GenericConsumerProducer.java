package ru.eugene.java.learn.generics;

public class GenericConsumerProducer {
    public static class Parent{
        private String name;

        public Parent(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Child extends Parent{
        public Child(String name) {
            super(name);
        }

        public void print(){
            System.out.println("child");
        }
    }

    public interface Producer<T>{
        T produce();
    }

    public interface Consumer<T>{
        void consume(T obj);
    }

    public void setProducer(Producer<? extends Parent> producer){
        Parent parent = producer.produce();
        System.out.println(parent.getName());
    }

    public void setConsumer(Consumer<? super Child> consumer, Child child){
        consumer.consume(child);
    }
}
