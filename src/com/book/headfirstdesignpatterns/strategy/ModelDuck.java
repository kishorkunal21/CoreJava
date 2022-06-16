package com.book.headfirstdesignpatterns.strategy;

public class ModelDuck extends Duck{

    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("I'm a Model Duck !!");
    }
}
