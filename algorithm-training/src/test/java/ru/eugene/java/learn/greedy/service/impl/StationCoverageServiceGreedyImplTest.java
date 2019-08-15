package ru.eugene.java.learn.greedy.service.impl;

import org.junit.Before;
import org.junit.Test;
import ru.eugene.java.learn.greedy.model.Government;
import ru.eugene.java.learn.greedy.model.RadioStation;
import ru.eugene.java.learn.greedy.service.StationCoverageService;

import java.util.*;

public class StationCoverageServiceGreedyImplTest {
    private StationCoverageService stationCoverageService;

    @Before
    public void init(){
        stationCoverageService = new StationCoverageServiceGreedyImpl();
    }

    @Test
    public void getStationsTest(){
        Set<Government> states = new HashSet<>(
                Arrays.asList(
                        new Government("1"), new Government("2"),
                        new Government("3"), new Government("4"),
                        new Government("5"), new Government("6"),
                        new Government("7")));

        Map<RadioStation, Set<Government>> stationCoverage = new HashMap<>();

        stationCoverage.put(new RadioStation("1"), createStates(new Government("1")));
        stationCoverage.put(new RadioStation("2"), createStates(new Government("2")));
        stationCoverage.put(new RadioStation("3"), createStates(new Government("3")));
        stationCoverage.put(new RadioStation("4"), createStates(new Government("4")));
        stationCoverage.put(new RadioStation("5"), createStates(new Government("5")));
        stationCoverage.put(new RadioStation("6"), createStates(new Government("6")));
        stationCoverage.put(new RadioStation("7"), createStates(new Government("7")));

        Set<RadioStation> stations = stationCoverageService.getStations(states, stationCoverage);

        System.out.println("States: " + states);
        System.out.println("Station coverage: " + stationCoverage);
        System.out.println("Get stations: " + stations);
    }

    private Set<Government> createStates(Government... governments){
        return new HashSet<>(Arrays.asList(governments));
    }
}