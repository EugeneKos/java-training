package ru.eugene.java.learn.behaviour.mediator;

public class Text extends Component {
    private String currentText;

    public String getCurrentText() {
        return currentText;
    }

    public void setCurrentText(String currentText) {
        this.currentText = currentText;
    }

    @Override
    public String getName() {
        return "text";
    }
}
