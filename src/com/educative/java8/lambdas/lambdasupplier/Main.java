package com.educative.java8.lambdas.lambdasupplier;

/*Supplier is an interface that does not take in any argument but produces a value when the get() function is invoked.
Suppliers are useful when we don’t need to supply any value and obtain a result at the same time.*/

import com.educative.java8.lambdas.lambdacomparator.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("KK",32,"IN");
        Person person2 = new Person("MOTU",17,"IN");
        Person person3 = new Person("MOTU KA BHAI",21,"IN");
        List<Person> personList = new ArrayList<Person>(Arrays.asList(person,person2,person3));


        System.out.println("Using Supplier ->");
        for(Person p:personList){
            if(isEligibaleForVoting((p1)->{return p1.getAge()>18;},()->p))
                System.out.println(p.getName()+" "+p.getAge());
        }

        System.out.println("\n intSuplier ->");
        IntSupplier supplier = ()->(int) (Math.random()*10);
        System.out.println(supplier.getAsInt());

        System.out.println("\n doubleSupplier ->");
        DoubleSupplier doubleSupplier= ()->(Double) (Math.random()*10);
        System.out.println(doubleSupplier.getAsDouble());


    }

    static boolean isEligibaleForVoting(Predicate<Person> predicate, Supplier<Person> supplier){
        return predicate.test(supplier.get());
    }
}
