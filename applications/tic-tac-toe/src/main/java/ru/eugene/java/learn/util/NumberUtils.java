package ru.eugene.java.learn.util;

public final class NumberUtils {
    private static final int CHEAT_INCREMENT = 10;
    private static final int MAX_ALLOWED = 9;

    private NumberUtils(){}

    public static int handleNumber(int number){
        int cheat = cheat(number, CHEAT_INCREMENT);
        return number % cheat;
    }

    private static int cheat(int number, int start){
        int diff = number - start;
        if(diff > MAX_ALLOWED){
            return cheat(number, start + CHEAT_INCREMENT);
        }
        return start;
    }
}
