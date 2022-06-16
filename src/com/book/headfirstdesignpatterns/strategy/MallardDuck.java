package com.book.headfirstdesignpatterns.strategy;

public class MallardDuck extends Duck{
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }


    @Override
    void swim() {
        System.out.println("MallardDuck Swimming");
    }

    @Override
    void display() {
        System.out.println("This is the actual Mallard Duck");
    }
}
