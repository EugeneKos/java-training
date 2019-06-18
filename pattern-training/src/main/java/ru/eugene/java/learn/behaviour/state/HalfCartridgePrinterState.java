package ru.eugene.java.learn.behaviour.state;

public class HalfCartridgePrinterState implements PrinterState {
    private HPPrinter hpPrinter;

    public HalfCartridgePrinterState(HPPrinter hpPrinter) {
        this.hpPrinter = hpPrinter;
    }

    @Override
    public void print(String text) {
        if(hpPrinter.getPrintCycle() == 0){
            hpPrinter.setPrinterState(new EmptyCartridgePrinterState(hpPrinter));
        } else {
            hpPrinter.badPrintText(text);
        }
    }
}
