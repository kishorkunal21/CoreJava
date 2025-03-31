package com.book.modernjavainaction.behaviorparametarization;

import java.awt.color.ICC_Profile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
what we see below is behaviour parameterization in action -
it takes 2 strategy(different algos) and passes as behavior of the function
 */
public class Main {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(Color.RED, 155),
                new Apple(Color.GREEN, 10),
                new Apple(Color.GREEN, 100));
        System.out.println("AppleGreenColorAndWeightPredicate - "+filterApples(apples, new AppleGreenColorAndWeightPredicate()));
        System.out.println("AppleGreenColorPredicate - "+filterApples(apples, new AppleGreenColorPredicate()));

        System.out.println("#### using anonymous classes");

        filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.weight()>150;
            }
        });

        System.out.println("#### using LAMBDA");

        filterApples(apples, (Apple apple)-> {return apple.weight()>150;});


    }
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> appleList = new ArrayList<>();
        for(Apple apple:inventory){
            if(predicate.test(apple))
                appleList.add(apple);
        }
        System.out.println("FOUND : "+appleList);
        return appleList;
    }
}
