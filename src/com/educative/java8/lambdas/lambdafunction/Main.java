package com.educative.java8.lambdas.lambdafunction;

import java.util.function.BiFunction;
import java.util.function.Function;

//Function is a category of functional interfaces that takes an object of type T and returns an object of type R.
public class Main {
    public static void main(String[] args) {

        Function<Integer,Integer> function_square = x->x*x;
        System.out.println(function_square.apply(10));

        Function<String,Integer> function_length = x->x.length();
        System.out.println(function_length.apply("Kunal"));

        //compose(Function<? super V, ? extends T> before)#
        //Returns a composed function that first applies the function provided as a parameter on the input,
        //and then applies the function on which it is called, to the result.

        Function<Integer,Integer> increment = x->x+10;
        Function<Integer,Integer> multiply = x ->x*5;

        System.out.println("compose ::: " +increment.apply(3));
        System.out.println("compose ::: " +increment.compose(multiply).apply(3));//<-------direction
        System.out.println("compose ::: " +increment.compose(multiply).compose(increment).apply(3));//<-------direction 3+10 -> 13 *5 ->65 +10 =75


        BiFunction<Integer,Integer,Float> biFunction = (x,y)-> (float) (x * y);
        System.out.println(biFunction.apply(4,5));
    }
}
