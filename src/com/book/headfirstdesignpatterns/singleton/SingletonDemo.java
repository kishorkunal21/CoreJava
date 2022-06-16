package com.book.headfirstdesignpatterns.singleton;

public class SingletonDemo {

    //private static SingletonDemo uniqueSingletonInstance = new SingletonDemo(); //approach 1 : JVM dependent
    private static SingletonDemo uniqueSingletonInstance;

    private SingletonDemo(){
        System.out.println("Private constructor");
    }

    public static SingletonDemo getInstance(){

        if(uniqueSingletonInstance == null){
            synchronized (SingletonDemo.class){ //synchronised to be done only when there is no available instance
                uniqueSingletonInstance = new SingletonDemo();
            }
        }

        return uniqueSingletonInstance;

    }

}
