package com.mosh.designpatterns.behavioural.command;

public class LivingRoomLight implements Light{
    @Override
    public void on() {
        System.out.println("LivingRoomLight :: on");
    }

    @Override
    public void off() {
        System.out.println("LivingRoomLight :: off");
    }
}
