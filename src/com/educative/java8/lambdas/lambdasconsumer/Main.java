package com.educative.java8.lambdas.lambdasconsumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {

    //Consumers are functional interfaces that take in a parameter and do not produce anything.
    public static void main(String[] args) {
        Consumer<String> stringConsumer = s -> System.out.println("Hi "+s);
        stringConsumer.accept("kunal");
        stringConsumer.andThen((s2)-> System.out.println(s2.concat(" Jee"))).accept("Hello ");
        System.out.println("\n\n\n");
        stringConsumer.
                andThen((s2)-> System.out.println("How u doing ?"+ s2)).
                andThen((s)-> System.out.println("3rd line - "+s)).
                andThen((s)-> System.out.println("4th line - "+s)).
                accept("Ola ");

        BiConsumer<String,String> biConsumer = (s1,s2)-> System.out.println("\nbiConsumer -> "+ s1+" and "+s2);
        biConsumer.accept("k1","k2");
    }
}
