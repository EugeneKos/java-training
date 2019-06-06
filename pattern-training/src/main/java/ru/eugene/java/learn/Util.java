package ru.eugene.java.learn;

public final class Util {
    private final static int LENGTH = 81;
    private static int extra = 0;
    private static String pattern = "********************************** start " +
            " test **********************************";

    private Util(){}

    // fixme : Алгоритм полное дно, поправлю
    public static void printStartTest(String testName){
        String mes = new StringBuilder(pattern).insert(41, testName).toString();
        if(testName.length() > (LENGTH - 15)){
            extra = testName.length() - (LENGTH - 15);
            boolean side = true;
            for (int i = 0; i < extra; i++) {
                if(side){
                    mes = "*".concat(mes);
                    side = false;
                } else {
                    mes = mes.concat("*");
                    side = true;
                }
            }
            //throw new UnsupportedOperationException("Слишком длиное название теста");
        }
        boolean side = true;
        for (int i = 0; i < testName.length(); i++) {
            if(side){
                mes = mes.substring(1, mes.length());
                side = false;
            } else {
                mes = mes.substring(0, mes.length() - 1);
                side = true;
            }
        }
        System.out.println(mes);
    }

    public static void printFinishTest(){
        for (int i = 0; i < LENGTH + extra; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        printStartTest("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        System.out.println("information");
        printFinishTest();
    }
}
