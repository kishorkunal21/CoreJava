package com.book.modernjavainaction.streams.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));


    public static void main(String[] args) {
        menu.stream()
                .filter(dish -> dish.getCalories()>=400)
                .map(dish -> dish.getName())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        List<String> words = Arrays.asList("Kunal","Nishu","Motu","tuntun");
        words.stream().map(String::length).collect(Collectors.toList()).
                forEach(System.out::println);

        //words.stream().map(s -> s.split("")).collect(Collectors.toList()).forEach(sou);



    }
    static  void checkingStreamDetails(){

        System.out.println("\n checking streams");

        menu.stream()
                .filter(dish -> {
                    System.out.println("Filtering :: "+dish.getName());
                    return dish.getCalories() >= 400;
                })
                .map(dish -> {
                    System.out.println("mapping :: "+dish.getName());
                    return dish.getName();
                })

                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static void singleTraversalCheck(){
        //NOTE - Streams are traversable only once
        try {
            System.out.println("\n Streams are traversable only once");
            List<String> stringList = Arrays.asList("Modern","java","in","action");
            Stream s = stringList.stream();
            s.forEach(System.out::println);
            s.forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
