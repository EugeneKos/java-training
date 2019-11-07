package ru.eugene.java.learn;

import ru.eugene.java.learn.service.ZipUnpackerService;
import ru.eugene.java.learn.service.impl.ZipUnpackerServiceImpl;

import java.io.File;

public class ZipUnpacker {
    public static void main(String[] args) {
        unpack(args);
    }

    private static void unpack(String[] args){
        if(args == null || args.length == 0){
            throw new RuntimeException("Path to archive must be set");
        }

        ZipUnpackerService zipUnpackerService = new ZipUnpackerServiceImpl();
        zipUnpackerService.unpack(new File(args[0]));
    }
}
