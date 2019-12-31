package ru.eugene.java.learn.nodnok;

import org.junit.Test;

public class NodNokServiceTest {
    private NodNokService nodNokService = new NodNokService();

    @Test
    public void searchNodTest(){
        int[] numbers = new int[]{12, 18, 9};
        int nod = nodNokService.searchNod(numbers);
        System.out.println("NOD: " + nod);
    }

    @Test
    public void searchNokTest(){
        int[] numbers = new int[]{12, 18, 9};
        int nok = nodNokService.searchNok(numbers);
        System.out.println("NOK: " + nok);
    }
}