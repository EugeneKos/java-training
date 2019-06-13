package ru.eugene.java.learn.behaviour.mediator;

public class AuthenticationDialog implements Mediator {
    private Button button;
    private Text text;
    private Label label;

    @Override
    public void registryComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()){
            case "text":
                text = (Text) component;
                break;
            case "label":
                label = (Label) component;
                break;
            case "button":
                button = (Button) component;
                break;
        }
    }

    @Override
    public void show() {
        String currentText = text.getCurrentText();
        label.printText(currentText);
    }
}
