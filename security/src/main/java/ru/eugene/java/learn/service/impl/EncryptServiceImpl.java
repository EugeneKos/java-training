package ru.eugene.java.learn.service.impl;

import ru.eugene.java.learn.data.EncryptModel;
import ru.eugene.java.learn.service.EncryptService;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class EncryptServiceImpl implements EncryptService {
    private String key;

    public EncryptServiceImpl(String key) {
        this.key = key;
    }

    @Override
    public <T> EncryptModel<T> encrypt(String name, T object, Class<T> clazz) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(object);
            oos.flush();
            byte[] content = encryptContent(baos.toByteArray());
            return new EncryptModel<>(name, content, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] encryptContent(byte[] content){
        try {
            SecretKey secretKey = generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(content);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T decrypt(EncryptModel<T> model) {
        byte[] content = decryptContent(model.getEncryptData());
        ByteArrayInputStream bais = new ByteArrayInputStream(content);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            Object object = ois.readObject();
            return model.getClazz().cast(object);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] decryptContent(byte[] encryptContent){
        try {
            SecretKey secretKey = generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(encryptContent);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException |
                BadPaddingException  | IllegalBlockSizeException e) {

            throw new RuntimeException(e);
        }
    }

    private SecretKey generateKey() {
        byte[] keyBytes = Arrays.copyOf(key.getBytes(),16);
        return new SecretKeySpec(keyBytes, "AES");
    }
}
