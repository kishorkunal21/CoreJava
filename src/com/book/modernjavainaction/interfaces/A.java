package com.book.modernjavainaction.interfaces;

public interface A {
    default void hello(){
        System.out.println("Hello from A");
    }
}
