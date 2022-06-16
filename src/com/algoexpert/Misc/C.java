package com.algoexpert.Misc;

public interface C extends A,B{
    void method1();
    default void method2C(){
        //A.super.method2();
        System.out.println("C method");
    }
}
