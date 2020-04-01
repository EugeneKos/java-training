package ru.eugene.java.learn.behaviour.chainofresponsibility.filter.api;

public interface Filter {
    void doFilter(Request request, FilterChain chain);
}
