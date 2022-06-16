package com.educative.java8.lambdas.lambdacomparatorgreet;

public class Main {
    public static void main(String[] args) {
        Greet greet = new EnglishGreetings();
        greet.Greet();

        Greet greet1 = new HindiGreetings();
        greet1.Greet();
        System.out.println("---------------------Using anonymous class");
        wish(new Greet() {
            @Override
            public void Greet() {
                System.out.println("Spanish greet - OLA !");
            }
        });

        System.out.println("---------------------Using lambda");

        wish(()-> System.out.println("Greet in lambda"));

        System.out.println();

    }

    public static void wish(Greet greet){
        greet.Greet();
    }



}
