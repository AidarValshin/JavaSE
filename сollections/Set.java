package ru.Aidar.сollections;

import java.util.HashSet;
import java.util.TreeSet;
import static ru.Aidar.сollections.AllMethodsSet.*;

public class Set {
    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet();
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("add ");
        System.out.println("HashSet");
        System.out.println(addSet(hashSet));
        System.out.println("TreeSet");
        System.out.println(addSet(treeSet));
        System.out.println("");


        System.out.println("");
        System.out.println("find ");
        System.out.println("HashSet");
        System.out.println(FindSet(hashSet));
        System.out.println("TreeSet");
        System.out.println(FindSet(treeSet));


        System.out.println("");
        System.out.println("remove  first");
        System.out.println("HashSet");
        System.out.println(deleteSetFirst(hashSet));
        System.out.println("TreeSet");
        System.out.println(deleteSetFirst(treeSet));

        System.out.println("");
        System.out.println("remove  middle");
        System.out.println("HashSet");
        System.out.println(deleteSetMiddle(hashSet));
        System.out.println("TreeSet");
        System.out.println(deleteSetMiddle(treeSet));
        System.out.println("");
    }
}
