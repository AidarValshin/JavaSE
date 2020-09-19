package ru.Aidar.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class Proxy {
    public static void run(Class testClass) throws InvocationTargetException, IllegalAccessException {
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ShowMethodInstance.class)) {
                System.out.println("There is:  "+m.getReturnType()+" " + m.getName());
            }
        }
        
    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        run(ru.Aidar.сollections.AllMethodsList.class);
    }
}
