package ru.eugene.java.learn.behaviour.memento;

/**
 * Паттерн Снимок нужен для хранения состояния класса и при необходимости восстановления этого состояния.
 *
 * Как правило используется внутренний класс "Снимка (Memento)" с теми же полями, что и основной.
 * Также можно вынести его наружу, тогда в классе создателе (Person) должны быть геттеры и сеттеры, а в сам клас
 * Снимка передавать ссылку на создателя.
 */
public class Person {
    private String name;
    private String surName;
    private int age;

    private History<Memento> history = new History<>();

    public Person(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save(){
        history.push(new Memento(name, surName, age));
    }

    public void undo(){
        Memento memento = history.undo();
        if(memento != null){
            memento.restore();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * Класс снимка
     */
    private class Memento {
        private String name;
        private String surName;
        private int age;

        private Memento(String name, String surName, int age) {
            this.name = name;
            this.surName = surName;
            this.age = age;
        }

        private void restore(){
            Person.this.name = name;
            Person.this.surName = surName;
            Person.this.age = age;
        }
    }
}
