package ru.eugene.java.learn.greedy.service.impl;

import org.junit.Before;
import org.junit.Test;
import ru.eugene.java.learn.greedy.service.StationCoverageService;
import ru.eugene.java.learn.greedy.service.impl.StationCoverageServiceImpl;

import java.util.*;

public class StationCoverageServiceImplTest {
    private StationCoverageService stationCoverageService;

    @Before
    public void init(){
        stationCoverageService = new StationCoverageServiceImpl();
    }

    @Test
    public void getStationsTest(){
        Set<String> states = new HashSet<>(Arrays.asList("s1", "s2", "s3", "s4", "s5", "s6", "s7"));

        Map<String, Set<String>> stationCoverage = new HashMap<>();

        stationCoverage.put("st1", new HashSet<>(Arrays.asList("s1")));
        stationCoverage.put("st2", new HashSet<>(Arrays.asList("s2")));
        stationCoverage.put("st3", new HashSet<>(Arrays.asList("s3")));
        stationCoverage.put("st4", new HashSet<>(Arrays.asList("s4")));
        stationCoverage.put("st5", new HashSet<>(Arrays.asList("s5")));
        stationCoverage.put("st6", new HashSet<>(Arrays.asList("s6")));
        stationCoverage.put("st7", new HashSet<>(Arrays.asList("s7")));

        Set<String> stations = stationCoverageService.getStations(states, stationCoverage);

        System.out.println("States: " + states);
        System.out.println("Station coverage: " + stationCoverage);
        System.out.println("Get stations: " + stations);
    }
}