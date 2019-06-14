package ru.eugene.java.learn.behaviour.observer;

public class NewProductEventListener implements EventListener {
    @Override
    public void onEvent() {
        System.out.println("Ура ! Завезли новый товар, схожу посмотреть");
    }
}
