package com.misc.random;

import java.util.List;
import java.util.Objects;

/*
Why Does Java Choose method(String list)?
Java's overload resolution picks the most specific method that can accept the argument. The rules are:
null is compatible with any reference type.
If multiple methods accept null, Java chooses the most specific one.
In this case:
String is a subclass of Object.
String is more specific than Object.
So, method(String list) is more specific and is chosen over method(Object list).

A type is "more specific" than another if it is a subtype of the other.
For example, String is more specific than Object, because String is a subclass of Object.
Similarly, Integer is more specific than Number, because Integer is a subclass of Number.

Key Point
"Most specific" in Java overloading means the parameter type that is the closest (most specialized) in the inheritance hierarchy to the argument type. For null, it means the most specific reference type in the overloaded methods.
 */
public class ClassOverrideNullCall {
    public static void main(String[] args) {
        method(null);
    }

    static void method(String list) {
        System.out.println("inside string call");
    }

    static void method(Object list) {
        System.out.println("inside Integer call");
    }

    /* following code causes compile-time ambiguity error
    static void method(String list){
        System.out.println("inside string call");
    }
    static void method(Integer list){
        System.out.println("inside string call");
    }*/

    /*
    same erasure problem
    static void method(List<String> list){
        System.out.println("inside string call");
    }
    static void method(List<Integer> list){
        System.out.println("inside string call");
    }*/
}
