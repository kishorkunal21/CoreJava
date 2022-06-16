package com.algoexpert.Misc;

public interface A {
    void method1();
    default void method2(){
        System.out.println("A default method");
    }
}
