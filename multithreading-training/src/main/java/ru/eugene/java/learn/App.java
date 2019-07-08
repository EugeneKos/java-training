package ru.eugene.java.learn;

import ru.eugene.java.learn.service.IncrementMasterService;

public class App {
    public static void main(String[] args) {
        testSynchronized();
    }

    private static void testSynchronized() {
        IncrementMasterService service = new IncrementMasterService(false);
        service.doIt();
    }
}
