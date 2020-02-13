package ru.eugene.java.learn.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyAnnotatedBean1 {
    @Value("${phone}")
    private String phone;

    public String getPhone() {
        return phone;
    }
}
