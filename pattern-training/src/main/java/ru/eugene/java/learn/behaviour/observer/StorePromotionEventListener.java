package ru.eugene.java.learn.behaviour.observer;

public class StorePromotionEventListener implements EventListener {
    @Override
    public void onEvent() {
        System.out.println("Ура ! Пойду покупать товар со скидкой");
    }
}
