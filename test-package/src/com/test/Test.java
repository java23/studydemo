package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Collection<Student> collection = new ArrayList<>();
        Student xiaoming = new Student("小明",23);
        Student xiaoli = new Student("小李",22);
        collection.add(xiaoli);
        collection.add(xiaoming);
        Iterator<Student> iterator = collection.iterator();
        while (iterator.hasNext()){

            System.out.println( iterator.next());
        }



    }
}
