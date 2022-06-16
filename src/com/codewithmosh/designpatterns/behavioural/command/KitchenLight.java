package com.codewithmosh.designpatterns.behavioural.command;

public class KitchenLight implements Light{
    @Override
    public void on() {
        System.out.println("KitchenLight :: on");
    }

    @Override
    public void off() {
        System.out.println("KitchenLight :: off");
    }
}
