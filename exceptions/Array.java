package ru.Aidar.exceptions;

import java.util.ArrayList;

public class Array {
    ArrayList arrayList;
    public Array(ArrayList<Integer> arrayList){
        this.arrayList=arrayList;
    }

    public void add(int i){
        if(arrayList.size()<10){
            arrayList.add(i);
        }
        else {
            throw new ArrayListIndexOutOfBoundsException();
        }
    }
}
