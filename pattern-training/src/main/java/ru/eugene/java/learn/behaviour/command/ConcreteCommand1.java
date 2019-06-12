package ru.eugene.java.learn.behaviour.command;

public class ConcreteCommand1 implements Command {
    private int parameter;
    private Receiver receiver;

    public ConcreteCommand1(int parameter, Receiver receiver) {
        this.parameter = parameter;
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.logic(parameter);
    }
}
