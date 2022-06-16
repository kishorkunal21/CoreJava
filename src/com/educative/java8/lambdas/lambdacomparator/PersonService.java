package com.educative.java8.lambdas.lambdacomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    static List<Person> getList(List<Person> personList){

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return personList;
    }

    static List<Person> getListLamda(List<Person> personList){

        Collections.sort(personList, (o1,o2)->o2.getName().compareTo(o1.getName())
        );

        return personList;
    }


    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("KK",32,"IN"));
        personList.add(new Person("PK",32,"PK"));
        personList.add(new Person("RK",32,"BG"));

        personList=getList(personList);
        for(Person person:personList){
            System.out.println(person.getName());
        }

        System.out.println("Using lambda.....");
        personList=getListLamda(personList);
        for(Person person:personList){
            System.out.println(person.getName());
        }


    }
}
