package ru.eugene.java.learn.behaviour.strategy;

public class WalkingStrategy implements RouteStrategy {
    @Override
    public void buildRoute(char a, char b) {
        System.out.println("Построил маршрут через парк от точки " + a + " до точки " + b);
    }
}
