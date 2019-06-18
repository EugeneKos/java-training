package ru.eugene.java.learn.behaviour.state;

public class EmptyCartridgePrinterState implements PrinterState {
    private HPPrinter hpPrinter;

    public EmptyCartridgePrinterState(HPPrinter hpPrinter) {
        this.hpPrinter = hpPrinter;
    }

    @Override
    public void print(String text) {
        //throw new RuntimeException("cartridge is empty: " + hpPrinter.getPrintCycle());
        hpPrinter.changeCartridge();
        hpPrinter.setPrinterState(new FullCartridgePrinterState(hpPrinter));
    }
}
