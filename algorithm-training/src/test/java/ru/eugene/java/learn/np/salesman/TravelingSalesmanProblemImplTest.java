package ru.eugene.java.learn.np.salesman;

import org.junit.Test;
import ru.eugene.java.learn.np.PermutationsAlgorithmImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TravelingSalesmanProblemImplTest {
    @Test
    public void findTimeShortestRoadwayTest(){
        TravelingSalesmanProblem travelingSalesmanProblem = new TravelingSalesmanProblemImpl(new PermutationsAlgorithmImpl<>());

        Set<Roadway> roadways = new HashSet<>(Arrays.asList(
                new Roadway(new City("A"), new City("B"), 5),
                new Roadway(new City("B"), new City("A"), 3),
                new Roadway(new City("A"), new City("C"), 6),
                new Roadway(new City("C"), new City("A"), 7),
                new Roadway(new City("B"), new City("C"), 2),
                new Roadway(new City("C"), new City("B"), 4),
                new Roadway(new City("A"), new City("D"), 2),
                new Roadway(new City("D"), new City("A"), 8),
                new Roadway(new City("D"), new City("C"), 5),
                new Roadway(new City("C"), new City("D"), 6),
                new Roadway(new City("D"), new City("B"), 12),
                new Roadway(new City("B"), new City("D"), 13)
        ));

        int shortestTime = travelingSalesmanProblem.findTimeShortestRoadway(roadways);

        System.out.println(shortestTime);
    }
}