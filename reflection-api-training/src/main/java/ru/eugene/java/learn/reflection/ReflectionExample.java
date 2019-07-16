package ru.eugene.java.learn.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public void testReflectionComputerModel() throws Exception {
        ComputerModel model = new ComputerModel("dell", 3, 16);
        System.out.println(model);

        Class modelClass = ComputerModel.class;
        Method[] methods = modelClass.getDeclaredMethods();
        Field[] fields = modelClass.getDeclaredFields();

        Field field = null;
        for (Field f : fields){
            if("memorySize".equals(f.getName())){
                field = f;
            }
        }
        if(field != null){
            field.setAccessible(true);
            field.setInt(model, 32);
        }
        System.out.println(model);

        Method method = null;
        for (Method m : methods){
            if("overclock".equals(m.getName())){
                method = m;
            }
        }
        if(method != null){
            method.setAccessible(true);
            method.invoke(model);
        }
        System.out.println(model);
    }
}
