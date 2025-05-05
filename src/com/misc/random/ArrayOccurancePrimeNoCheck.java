package com.misc.random;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayOccurancePrimeNoCheck {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1,1,1,1,2,2,2,2,3,3,3,4,4,4,4,5,5,5,5
        };
        List<Integer> integers =  IntStream.of(1,1,1,1,2,2,2,2,3,3,3,4,4,4,4,5,5,5,5).boxed().toList();

        integers.stream()
                .collect(Collectors.groupingBy(a->a,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(a->a.getValue()%2!=0)
                .forEach((e)->System.out.println(e.getKey()+" "+e.getValue()));
        //without streams

        int[] result = new int[arr.length];






    }
}
