package ru.eugene.java.learn.behaviour.command;

public class ConcreteCommand3 implements Command {
    private Receiver receiver;
    private String parameter;

    public ConcreteCommand3(Receiver receiver, String parameter) {
        this.receiver = receiver;
        this.parameter = parameter;
    }

    @Override
    public void execute() {
        receiver.logic(parameter);
    }
}
