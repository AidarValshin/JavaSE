package ru.Aidar.сollections;

import java.util.ArrayList;
import java.util.LinkedList;
import static ru.Aidar.сollections.AllMethodsList.*;
public class List {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
         System.out.println("add end");
        System.out.println("ArrayList");
        System.out.println(addList(arrayList));
        System.out.println("LinkedList");
        System.out.println(addList(linkedList));
        arrayList.clear();
        linkedList.clear();
        System.out.println("");
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        System.out.println("add first");
        System.out.println("ArrayList");
        System.out.println(addListFirst(arrayList));
        System.out.println("LinkedList");
        System.out.println(addListFirst(linkedList));
        arrayList.clear();
        linkedList.clear();
        System.out.println("");

        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        System.out.println("add middle");
        System.out.println("ArrayList");
        System.out.println(addListMiddle(arrayList));
        System.out.println("LinkedList");
        System.out.println(addListMiddle(linkedList));

        System.out.println("");
        System.out.println("find middle");
        System.out.println("ArrayList");
        System.out.println(FindListMiddle(arrayList));
        System.out.println("LinkedList");
        System.out.println(FindListMiddle(linkedList));

        System.out.println("");
        System.out.println("remove  end");
        System.out.println("ArrayList");
        System.out.println(deleteList(arrayList));
        System.out.println("LinkedList");
        System.out.println(deleteList(linkedList));

        System.out.println("");
        System.out.println("remove  first");
        System.out.println("ArrayList");
        System.out.println(deleteListFirst(arrayList));
        System.out.println("LinkedList");
        System.out.println(deleteListFirst(linkedList));

        System.out.println("");
        System.out.println("remove  middle");
        System.out.println("ArrayList");
        System.out.println(deleteListMiddle(arrayList));
        System.out.println("LinkedList");
        System.out.println(deleteListMiddle(linkedList));
        System.out.println("");
    }
}