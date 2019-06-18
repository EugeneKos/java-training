package ru.eugene.java.learn.behaviour.visitor;

public class VisitorImpl implements Visitor {
    @Override
    public void visit(User user) {
        System.out.println("Возьму имя User и что-нибудь с ним сделаю. User.name: " + user.getName());
    }

    @Override
    public void visit(Bank bank) {
        System.out.println("Возьму имя Bank и что-нибудь с ним сделаю. User.name: " + bank.getName());
    }
}
