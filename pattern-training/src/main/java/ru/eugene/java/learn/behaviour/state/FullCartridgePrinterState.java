package ru.eugene.java.learn.behaviour.state;

public class FullCartridgePrinterState implements PrinterState {
    private HPPrinter hpPrinter;

    public FullCartridgePrinterState(HPPrinter hpPrinter) {
        this.hpPrinter = hpPrinter;
    }

    @Override
    public void print(String text) {
        if(hpPrinter.getPrintCycle() >= 60){
            hpPrinter.goodPrintText(text);
        } else {
            hpPrinter.setPrinterState(new HalfCartridgePrinterState(hpPrinter));
        }
    }
}
