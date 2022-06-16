package com.book.headfirstdesignpatterns.strategy;

public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Flying with Rocket !!");
    }
}
