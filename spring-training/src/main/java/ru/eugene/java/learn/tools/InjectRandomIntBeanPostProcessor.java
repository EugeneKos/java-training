package ru.eugene.java.learn.tools;

import ru.eugene.java.learn.annotation.InjectRandomInt;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] beanClassFields = beanClass.getDeclaredFields();
        for (Field beanClassField : beanClassFields){
            InjectRandomInt injectRandomInt = beanClassField.getAnnotation(InjectRandomInt.class);
            if(injectRandomInt != null) {
                int min = injectRandomInt.min();
                int max = injectRandomInt.max();

                Random random = new Random();
                int randomInt = min + random.nextInt(max - min);

                beanClassField.setAccessible(true);
                ReflectionUtils.setField(beanClassField, bean, randomInt);
            }

        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
