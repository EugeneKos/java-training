package ru.eugene.java.learn.service.impl;

import ru.eugene.java.learn.service.ZipUnpackerService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUnpackerServiceImpl implements ZipUnpackerService {
    private static final String EXTENSION_POINT = ".";
    private static final String SEPARATOR = "/";

    @Override
    public void unpack(File zip) {
        try (ZipFile zipFile = new ZipFile(zip)){
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()){
                ZipEntry zipEntry = entries.nextElement();
                if(!zipEntry.isDirectory()){
                    System.out.println("Extract: " + zipEntry.getName());
                    String fullFileName = deleteExtension(zip.getCanonicalPath()) + File.separator + zipEntry.getName();
                    write(zipFile.getInputStream(zipEntry), fullFileName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String deleteExtension(String fullPath){
        int lastIndexOfExtensionPoint = fullPath.lastIndexOf(EXTENSION_POINT);
        return fullPath.substring(0, lastIndexOfExtensionPoint);
    }

    private void write(InputStream inputStream, String fullFileName){
        createDirectory(fullFileName);
        try (FileOutputStream fis = new FileOutputStream(new File(fullFileName))){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }
            fis.write(baos.toByteArray());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void createDirectory(String fullFileName){
        int lastIndexOfSeparator = fullFileName.lastIndexOf(SEPARATOR);
        fullFileName = fullFileName.substring(0, lastIndexOfSeparator + 1);
        try {
            Files.createDirectories(Paths.get(fullFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
