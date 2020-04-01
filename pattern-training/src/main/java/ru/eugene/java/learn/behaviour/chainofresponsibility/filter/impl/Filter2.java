package ru.eugene.java.learn.behaviour.chainofresponsibility.filter.impl;

import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.api.Filter;
import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.api.FilterChain;
import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.api.Request;

public class Filter2 implements Filter {
    @Override
    public void doFilter(Request request, FilterChain chain) {
        System.out.println("filter 2 work");
        chain.doFilter(request);
    }
}
