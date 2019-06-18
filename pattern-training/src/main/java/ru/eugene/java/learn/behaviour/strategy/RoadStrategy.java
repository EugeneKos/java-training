package ru.eugene.java.learn.behaviour.strategy;

public class RoadStrategy implements RouteStrategy {
    @Override
    public void buildRoute(char a, char b) {
        System.out.println("Построил маршрут на автомобиле от точки " + a + " до точки " + b);
    }
}
