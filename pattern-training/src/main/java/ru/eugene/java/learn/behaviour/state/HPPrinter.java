package ru.eugene.java.learn.behaviour.state;

public class HPPrinter {
    private PrinterState state;
    private int printCycle = 200;

    public void setPrinterState(PrinterState state) {
        this.state = state;
    }

    public void changeCartridge(){
        printCycle = 200;
    }

    public int getPrintCycle() {
        return printCycle;
    }

    /**
     * Метод который делигирует выполнение объектам состояния, тот в свою очередь может поменять состояние или
     * вызвать другой метод основного класса
     * @param text
     */
    public void print(String text){
        state.print(text);
    }

    public void goodPrintText(String text){
        System.out.println("Good print :) " + text);
        printCycle--;
    }

    public void badPrintText(String text){
        System.out.println("Bad print :( " + text);
        printCycle--;
    }
}
