package ru.eugene.java.learn.behaviour.mediator;

public class Label extends Component {
    @Override
    public String getName() {
        return "label";
    }

    public void printText(String text){
        System.out.println("GUI printed: " + text);
    }
}
