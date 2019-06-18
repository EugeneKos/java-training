package ru.eugene.java.learn.behaviour.strategy;

public class Navigator {
    private RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void buildRoute(char a, char b){
        routeStrategy.buildRoute(a, b);
    }
}
