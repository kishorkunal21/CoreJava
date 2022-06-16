package com.book.headfirstdesignpatterns.singleton;

public class Main {
    public static void main(String[] args) {
        //SingletonDemo singletonDemo = new SingletonDemo();// cant do this because this has a private constructor

        SingletonDemo singletonDemo = SingletonDemo.getInstance();
        System.out.println("Hshcode of singletonInstance ::: "+singletonDemo.hashCode());
        System.out.println("Initializing again...");
        SingletonDemo singletonDemo1 = SingletonDemo.getInstance();
        System.out.println("Hshcode of singletonInstance ::: "+singletonDemo1.hashCode());
        System.out.println("\n_______________________________________");
        if(singletonDemo==singletonDemo1)
            System.out.println("SINGLETON INSTANCE CONFIRMED");

        System.out.println("_______________________________________");




    }
}
