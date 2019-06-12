package ru.eugene.java.learn.behaviour.command;

public class GUI {
    private Receiver receiver = new Receiver();

    public void clickButton(){
        action(new ConcreteCommand1(23, receiver));
    }

    void action(Command command){
        command.execute();
    }
}
