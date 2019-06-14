package ru.eugene.java.learn.behaviour;

import ru.eugene.java.learn.behaviour.chainofresponsibility.MessageChecker;
import ru.eugene.java.learn.behaviour.command.GUI;
import ru.eugene.java.learn.behaviour.mediator.*;
import ru.eugene.java.learn.behaviour.observer.*;

public class BehaviourMain {
    public static void main(String[] args) {
        testChainOfResponsibility();
        testCommand();
        testMediator();
        testObserver();
    }

    private static void testChainOfResponsibility(){
        MessageChecker messageChecker = new MessageChecker();
        messageChecker.checkMessage("ckffANH8as");
    }

    private static void testCommand(){
        GUI gui = new GUI();
        gui.clickButton();
    }

    private static void testMediator(){
        Mediator mediator = new AuthenticationDialog();

        Button button = new Button();
        Label label = new Label();
        Text text = new Text();

        mediator.registryComponent(button);
        mediator.registryComponent(text);
        mediator.registryComponent(label);

        // имитируем набор текста в текстовое поле
        text.setCurrentText("Hi I am Mediator");
        button.click();
    }

    private static void testObserver(){
        EventManager eventManager = new EventManager();
        eventManager.addSubscribe(EventType.NEW_PRODUCT, new NewProductEventListener());
        eventManager.addSubscribe(EventType.STORE_PROMOTION, new StorePromotionEventListener());

        Shop shop = new Shop(eventManager);
        shop.newProduct();
        shop.sale();
    }
}
