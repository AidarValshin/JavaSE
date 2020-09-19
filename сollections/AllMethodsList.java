package ru.Aidar.сollections;

import ru.Aidar.reflection.ShowMethodInstance;

import java.util.List;

public class AllMethodsList {
    @ShowMethodInstance
    public static long  addList(List list) {

        for (int i = 100000; i >= 0; i--) {
            list.add(i);
        }
        long start = System.nanoTime();
        for (int i = 1000; i >= 0; i--) {
            list.add(i);
        }
        long    end = System.nanoTime();
        return (end - start)/1000;
    }
    @ShowMethodInstance
    public static long addListFirst(List list) {
        for (int i = 100000; i >= 0; i--) {
            list.add(0,i);
        }
        long start = System.nanoTime();
        for (int i = 1000; i >= 0; i--) {
            list.add(0,i);
        }
        long    end = System.nanoTime();
        return (end - start)/1000;
    }

    @ShowMethodInstance
    public static long addListMiddle(List list) {

        for (int i = 100000; i >= 0; i--) {
            list.add(list.size()/2, i);
        }
        long start = System.nanoTime();
        for (int i = 1000; i >= 0; i--) {
            list.add(5000, i);
        }
        long end = System.nanoTime();
        return (end - start) / 1000;
    }
    @ShowMethodInstance
    public static long FindListMiddle(List list) {

        for (int i = 100000; i >= 0; i--) {
            list.get(i);
        }
        long start = System.nanoTime();
        for (int i = 1000; i >= 0; i--) {
            list.get(5000+i);
        }
        long end = System.nanoTime();
        return (end - start) / 1000;
    }
    @ShowMethodInstance
    public static long  deleteList(List list) {
        long start = System.nanoTime();
        for (int i = 1000; i >= 0; i--) {
            list.remove(list.size()-1);
        }
        long    end = System.nanoTime();
        return (end - start)/1000;
    }
    @ShowMethodInstance
    public static long deleteListFirst(List list) {
        for (int i = 5000; i >= 0; i--) {
            list.remove(0);
        }
        long start = System.nanoTime();
        for (int i = 1000; i >= 0; i--) {
            list.remove(0);
        }
        long    end = System.nanoTime();
        return (end - start)/1000;
    }

    @ShowMethodInstance
    public static long deleteListMiddle(List list) {

        long start = System.nanoTime();
        for (int i = 1000; i >= 0; i--) {
            list.remove( i);
        }
        long end = System.nanoTime();
        return (end - start) / 1000;
    }
}
