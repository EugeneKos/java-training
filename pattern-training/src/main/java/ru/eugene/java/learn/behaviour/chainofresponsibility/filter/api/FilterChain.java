package ru.eugene.java.learn.behaviour.chainofresponsibility.filter.api;

public interface FilterChain {
    void doFilter(Request request);
}
