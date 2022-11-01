package com.book;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {
        List<Person> myList = new ArrayList<>();
        myList.add(new Person(10, "Ahmed"));
        myList.add(new Person(5, "Mohamed"));
        myList.add(new Person(20, "Dawi"));
        System.out.println(
                myList.stream().map(p->p.getNa)
        );

    }



}

class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

