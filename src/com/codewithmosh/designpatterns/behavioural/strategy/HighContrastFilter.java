package com.codewithmosh.designpatterns.behavioural.strategy;

public class HighContrastFilter implements Filter{
    @Override
    public void filter() {
        System.out.println("HighContrastFilter running..");
    }
}
