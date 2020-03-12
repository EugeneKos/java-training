package ru.eugene.java.learn.behaviour.chainofresponsibility.filter.impl;

import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.api.Filter;
import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.api.FilterChain;
import ru.eugene.java.learn.behaviour.chainofresponsibility.filter.api.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FilterChainImpl implements FilterChain {
    private List<Filter> filters = new ArrayList<>();

    private Iterator<Filter> iterator;

    public void addFilters(Filter... filters){
        this.filters.addAll(Arrays.asList(filters));
        iterator = this.filters.iterator();
    }

    @Override
    public void doFilter(Request request) {
        if(iterator.hasNext()){
            iterator.next().doFilter(request, this);
        }
    }
}
