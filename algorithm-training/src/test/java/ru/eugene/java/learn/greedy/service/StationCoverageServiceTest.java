package ru.eugene.java.learn.greedy.service;

import org.junit.Test;
import ru.eugene.java.learn.greedy.model.Government;
import ru.eugene.java.learn.greedy.model.RadioStation;
import ru.eugene.java.learn.greedy.service.impl.ExponentialSetServiceImpl;
import ru.eugene.java.learn.greedy.service.impl.StationCoverageServiceGreedyImpl;
import ru.eugene.java.learn.greedy.service.impl.StationCoverageServiceNPFullImpl;

import java.util.*;

public class StationCoverageServiceTest {
    @Test
    public void stationCoverageGreedyImplTest(){
        StationCoverageService service = new StationCoverageServiceGreedyImpl();

        Set<Government> states = getStates();
        Map<RadioStation, Set<Government>> stationCoverage = getMapping();

        long startTime = System.nanoTime();
        Set<RadioStation> stations = service.getStations(states, stationCoverage);
        long finTime = System.nanoTime();

        System.out.println("use greedy. Time: " + (finTime - startTime) * 0.00001 + " ms");
        System.out.println(stations);
    }

    @Test
    public void stationCoverageNPFullImplTest(){
        StationCoverageService service = new StationCoverageServiceNPFullImpl(new ExponentialSetServiceImpl<>());

        Set<Government> states = getStates();
        Map<RadioStation, Set<Government>> stationCoverage = getMapping();

        long startTime = System.nanoTime();
        Set<RadioStation> stations = service.getStations(states, stationCoverage);
        long finTime = System.nanoTime();

        System.out.println("use NP full. Time: " + (finTime - startTime) * 0.00001 + " ms");
        System.out.println(stations);
    }

    private Map<RadioStation, Set<Government>> getMapping(){
        Map<RadioStation, Set<Government>> map = new HashMap<>();

        map.put(new RadioStation("1"), new HashSet<>(Arrays.asList(
                new Government("1"),
                new Government("5"),
                new Government("8")
        )));

        map.put(new RadioStation("2"), new HashSet<>(Arrays.asList(
                new Government("2"),
                new Government("9")
        )));

        map.put(new RadioStation("3"), new HashSet<>(Arrays.asList(
                new Government("4"),
                new Government("3"),
                new Government("7")
        )));

        map.put(new RadioStation("4"), new HashSet<>(Arrays.asList(
                new Government("6"),
                new Government("9")
        )));

        map.put(new RadioStation("5"), new HashSet<>(Arrays.asList(
                new Government("10"),
                new Government("7"),
                new Government("3")
        )));

        map.put(new RadioStation("6"), new HashSet<>(Arrays.asList(
                new Government("6"),
                new Government("5"),
                new Government("8")
        )));

        map.put(new RadioStation("7"), new HashSet<>(Arrays.asList(
                new Government("4"),
                new Government("6"),
                new Government("1")
        )));

        map.put(new RadioStation("8"), new HashSet<>(Collections.singletonList(
                new Government("10")
        )));

        return map;
    }

    private Set<Government> getStates(){
        Set<Government> states = new HashSet<>();
        states.add(new Government("1"));
        states.add(new Government("2"));
        states.add(new Government("3"));
        states.add(new Government("4"));
        states.add(new Government("5"));
        states.add(new Government("6"));
        states.add(new Government("7"));
        states.add(new Government("8"));
        states.add(new Government("9"));
        states.add(new Government("10"));
        return states;
    }

}