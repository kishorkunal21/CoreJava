package com.codewithmosh.algorthm2.binarytrees;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    static int factorial(int n){

        if(n<=0){ //exit condition
            return 1;
        }
        else{
            return n*factorial(n-1);
        }

    }
}
