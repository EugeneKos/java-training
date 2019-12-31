package ru.eugene.java.learn.nodnok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Сервис для нахождения НОД - Наибольший общий делитель,
 * и НОК - Наименьшее общее кратное.
 */
public class NodNokService {
    /**
     * Поиск Наибольшего общего делителя
     *
     * @param numbers Входной массив чисел
     * @return nod
     */
    public int searchNod(int... numbers){
        if(numbers.length == 0){
            return 0;
        }
        LinkedList<Integer> allApproachNod = new LinkedList<>();
        int currentNod = 1;

        int numbersAmount = numbers.length;
        Arrays.sort(numbers);
        int minElement = numbers[0];

        while (currentNod <= minElement){
            for (int number : numbers){
                if(number % currentNod == 0){
                    numbersAmount--;
                }
            }
            if(numbersAmount == 0){
                allApproachNod.add(currentNod);
            }
            numbersAmount = numbers.length;
            currentNod++;
        }

        Collections.sort(allApproachNod);
        return allApproachNod.getLast();
    }

    /**
     * Поиск Наименьшего общего кратного
     *
     * @param numbers Входной массив чисел
     * @return nok
     */
    public int searchNok(int... numbers){
        if(numbers.length == 0){
            return 0;
        }

        List<List<Integer>> allNoksAllNumbers = new ArrayList<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            List<Integer> currentNumberNoks = new LinkedList<>();
            for (int j = 1; j <= numbers[i]; j++) {
                currentNumberNoks.add(numbers[i] * j);
            }
            allNoksAllNumbers.add(i, currentNumberNoks);
        }

        List<Integer> firstNumberNoks = allNoksAllNumbers.get(0);
        for (int i = 1; i < allNoksAllNumbers.size(); i++) {
            firstNumberNoks.retainAll(allNoksAllNumbers.get(i));
        }
        Collections.sort(firstNumberNoks);

        if(firstNumberNoks.isEmpty()){
            return 0;
        }

        return firstNumberNoks.get(0);
    }
}
