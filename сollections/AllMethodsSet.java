package ru.Aidar.сollections;

import java.util.Iterator;
import java.util.Set;

public class AllMethodsSet {
    public static long  addSet(Set set) {

        for (int i = 100000; i >= 0; i--) {
            set.add(i);
        }
        long start = System.nanoTime();
        for (int i = 10001; i <=11000; i++) {
            set.add(i);
        }
        long    end = System.nanoTime();
        return (end - start)/1000;
    }


    public static long FindSet(java.util.Set set) {
        Iterator iterator = set.iterator();
        for (int i = 100000; i >= 0; i--) {
            iterator.next();
        }
        long start = System.nanoTime();
        iterator = set.iterator();
        for (int i = 5000; i <= 10000; i++) {
            iterator.next();
        }
        long end = System.nanoTime();
        return (end - start) / 5000;
    }


    public static long deleteSetFirst(java.util.Set set) {

        long start = System.nanoTime();
        for (int i = 5000; i <5101; i++) {
            set.remove(i);
        }
        long    end = System.nanoTime();
        return (end - start)/100;
    }


    public static long deleteSetMiddle(Set set) {

        long start = System.nanoTime();
        for (int i = 7000; i <8000; i++) {
            set.remove( i);
        }
        long end = System.nanoTime();
        return (end - start) / 1000;
    }
}
