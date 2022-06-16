package com.mosh.designpatterns.behavioural.command;

public class BedroomLight implements Light{
    @Override
    public void on() {
        System.out.println("BedroomLight :: on");
    }

    @Override
    public void off() {
        System.out.println("BedroomLight :: off");
    }
}
