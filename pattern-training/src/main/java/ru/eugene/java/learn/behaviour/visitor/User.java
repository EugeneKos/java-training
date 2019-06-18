package ru.eugene.java.learn.behaviour.visitor;

public class User {
    private Long id;
    private String name;
    private String pass;

    public User(Long id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    // Some methods

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
