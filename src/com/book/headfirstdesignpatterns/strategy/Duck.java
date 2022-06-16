package com.book.headfirstdesignpatterns.strategy;

public abstract class Duck {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;
    public Duck(){}

    void performQuack(){
        quackBehavior.quack();
    }

    void performFly(){
        flyBehavior.fly();
    }

    void swim(){
        System.out.println("All ducks swim, even decoys!");
    };

    abstract void display();

    void setFlyBehavior(FlyBehavior fb){
        this.flyBehavior=fb;
    }

    void setQuackBehavior(QuackBehavior qk){
        this.quackBehavior=qk;
    }


}
