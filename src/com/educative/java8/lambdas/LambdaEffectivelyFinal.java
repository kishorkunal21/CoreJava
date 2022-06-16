package com.educative.java8.lambdas;

import java.util.function.UnaryOperator;

public class LambdaEffectivelyFinal {

    /*
    local variable passed to lambda should be either final or effectively final
    this is because when a variable is passed in lambda, it makes a copy of the variable and
    there is a possibility that the value might get changed by the time lambda is finished processing.
    Effectively final is a new concept that was introduced in Java 8.
    Compiler checks the local variable, if it is not changed after initialization then it is
    "effective final"
    A non-final, local variable whose value is never changed after initialization is known as effectively final.*/



    public static void main(String[] args) {

        int i = 5;
        //i = 7; // cant change here

        UnaryOperator<Integer> unaryOperator = x->x*i;

        System.out.println(unaryOperator.apply(5));


    }
}
