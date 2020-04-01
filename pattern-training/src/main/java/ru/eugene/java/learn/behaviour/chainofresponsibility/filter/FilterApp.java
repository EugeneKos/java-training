package ru.eugene.java.learn.behaviour.chainofresponsibility.filter;

import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.api.Request;
import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.impl.Filter1;
import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.impl.Filter2;
import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.impl.Filter3;

import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.impl.FilterChainImpl;

public class FilterApp {
    public static void main(String[] args) {
        FilterChainImpl filterChain = new FilterChainImpl();
        filterChain.addFilters(new Filter1(), new Filter2(), new Filter3());
        filterChain.doFilter(new Request() {});
    }
}
