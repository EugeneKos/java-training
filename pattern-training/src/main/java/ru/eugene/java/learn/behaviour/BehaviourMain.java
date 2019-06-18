package ru.eugene.java.learn.behaviour;

import ru.eugene.java.learn.behaviour.chainofresponsibility.MessageChecker;
import ru.eugene.java.learn.behaviour.command.GUI;
import ru.eugene.java.learn.behaviour.iterator.CustomArray;
import ru.eugene.java.learn.behaviour.mediator.*;
import ru.eugene.java.learn.behaviour.observer.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BehaviourMain {
    public static void main(String[] args) {
        testChainOfResponsibility();
        testCommand();
        testMediator();
        testIterator();
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

    private static void testIterator(){
        List<Long> items = new ArrayList<>();
        items.add(1L);
        items.add(2L);
        items.add(3L);
        items.add(4L);
        items.add(5L);

        Iterator<Long> iterator = items.iterator();
        while (iterator.hasNext()){
            Long item = iterator.next();
            if(item.equals(3L)){
                iterator.remove();
            }
            System.out.println("ArrayList item: " + item);
        }

        /*for (Long item : items){
            if(item.equals(3L)){
                items.remove(item);
            }
            System.out.println("ArrayList item: " + item);
        }*/

        /*for (int i=0; i<items.size(); i++){
            if(items.get(i).equals(3L)){
                items.remove(i);
            }
        }*/

        System.out.println("ArrayList: " + items);

        CustomArray<Long> customArray = new CustomArray<>();
        customArray.add(1L);
        customArray.add(2L);
        customArray.add(3L);
        customArray.add(4L);
        customArray.add(5L);
        customArray.add(6L);

        System.out.println("CustomArray: " + customArray);
        System.out.println("CustomArray get: " + customArray.get(4));
        //System.out.println("CustomArray remove: " + customArray.remove(3));

        /*for (int i=0; i<customArray.size(); i++){
            if(customArray.get(i).equals(2L)){
                customArray.remove(i);
            }
        }*/

        /*for (Long item : customArray){
            if(item.equals(2L)){
                customArray.remove(1);
            }
            System.out.println("CustomArray item: " + item);
        }*/

        Iterator<Long> iterator2 = customArray.iterator();
        while (iterator2.hasNext()){
            Long item = iterator2.next();
            if(item.equals(2L)){
                iterator2.remove();
            }
            System.out.println("CustomArray item: " + item);
        }

        //customArray.add(8L);
        System.out.println("CustomArray: " + customArray);
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
