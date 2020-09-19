package ru.Aidar.exceptions;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<Integer>();
        Array array = new Array(arr);
        try {
            for (int i = 0; i < 11; i++) {
                array.add(i);
            }
        }
        catch (ArrayListIndexOutOfBoundsException ex){
            System.out.println(arr);
            System.out.println(ex);
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
