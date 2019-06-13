package ru.eugene.java.learn.behaviour.mediator;

public class Button extends Component {
    @Override
    public String getName() {
        return "button";
    }

    public void click(){
        mediator.show();
    }
}
