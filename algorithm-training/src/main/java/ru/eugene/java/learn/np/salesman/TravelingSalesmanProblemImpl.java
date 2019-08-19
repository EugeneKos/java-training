package ru.eugene.java.learn.np.salesman;

import ru.eugene.java.learn.np.PermutationsAlgorithm;

import java.util.*;

public class TravelingSalesmanProblemImpl implements TravelingSalesmanProblem {
    private PermutationsAlgorithm<City> permutationsAlgorithm;

    public TravelingSalesmanProblemImpl(PermutationsAlgorithm<City> permutationsAlgorithm) {
        this.permutationsAlgorithm = permutationsAlgorithm;
    }

    /**
     * Задача о коммивояжере.
     * Используется алгоритм всех перестановок,
     * то-есть всевозможных посещений для получения минимального времени.
     *
     * @param roadways Множество маршрутов от города до города
     * @return Минимальное время посещения всех городов.
     */
    @Override
    public int findTimeShortestRoadway(Set<Roadway> roadways) {
        int shortestTime = Integer.MAX_VALUE;
        Set<City> allCities = new HashSet<>();
        Map<Neighbors, Integer> roadwaysMap = fillAllCitiesAndGetMapping(allCities, roadways);
        List<List<City>> allCitiesPermutations = permutationsAlgorithm.findAllPermutations(allCities);
        for (List<City> subCities : allCitiesPermutations){
            int roadwayTime = 0;
            for (int i = 0; i < subCities.size() - 1; i++) {
                City current = subCities.get(i);
                City next = subCities.get(i + 1);
                roadwayTime += roadwaysMap.get(new Neighbors(current, next));
            }
            if(roadwayTime < shortestTime){
                shortestTime = roadwayTime;
            }
        }
        return shortestTime;
    }

    private Map<Neighbors, Integer> fillAllCitiesAndGetMapping(Set<City> allCities, Set<Roadway> roadways){
        Map<Neighbors, Integer> roadwaysMap = new HashMap<>();
        for (Roadway roadway : roadways){
            City fromCity = roadway.getFromCity();
            City toCity = roadway.getToCity();
            roadwaysMap.put(new Neighbors(fromCity, toCity), roadway.getTravelTime());
            allCities.add(fromCity);
            allCities.add(toCity);
        }
        return roadwaysMap;
    }

    private class Neighbors{
        private City firstCity;
        private City secondCity;

        Neighbors(City firstCity, City secondCity) {
            this.firstCity = firstCity;
            this.secondCity = secondCity;
        }

        public City getFirstCity() {
            return firstCity;
        }

        public City getSecondCity() {
            return secondCity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Neighbors neighbors = (Neighbors) o;
            return Objects.equals(firstCity, neighbors.firstCity) &&
                    Objects.equals(secondCity, neighbors.secondCity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstCity, secondCity);
        }
    }
}
