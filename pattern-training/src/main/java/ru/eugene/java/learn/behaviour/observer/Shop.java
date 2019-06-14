package ru.eugene.java.learn.behaviour.observer;

public class Shop {
    private EventManager eventManager;

    public Shop(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void sale(){
        eventManager.notifyAllSubscribes(EventType.STORE_PROMOTION);
    }

    public void newProduct(){
        eventManager.notifyAllSubscribes(EventType.NEW_PRODUCT);
    }
}
