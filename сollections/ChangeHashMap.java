package ru.Aidar.сollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ChangeHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 10);
        hashMap.put("B", 15);
        hashMap.put("C", 20);
        hashMap.put("D", 25);
        hashMap.put("E", 30);

        System.out.println("Initial Mappings are: " + hashMap);
        Set set = hashMap.entrySet();
        HashMap<Integer, String> hashMapReversed = new HashMap<>();
        System.out.println("The set is: " + set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            hashMapReversed.put((Integer) pair.getValue(), (String) pair.getKey());
        }
        System.out.println("Reversed Mappings are: " + hashMapReversed);

    }
}
