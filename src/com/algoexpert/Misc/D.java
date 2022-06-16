package com.algoexpert.Misc;

import java.util.Arrays;
import java.util.List;

public class D implements C,B,Comparable{
    @Override
    public void method1() {
        String s ="kunal kunal";
        String arr[]=s.split("");
        List<String> ss = Arrays.asList(arr);

    }

    public static void main(String[] args) {

        System.out.println();

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
