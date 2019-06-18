package ru.eugene.java.learn.behaviour.strategy;

public class PublicTransportStrategy implements RouteStrategy {
    @Override
    public void buildRoute(char a, char b) {
        System.out.println("Построил маршрут на общественном транспорте от точки " + a + " до точки " + b);
    }
}
