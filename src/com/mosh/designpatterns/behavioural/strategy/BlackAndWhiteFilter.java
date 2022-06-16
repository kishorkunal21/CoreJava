package com.mosh.designpatterns.behavioural.strategy;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void filter() {
        System.out.println("BlackAndWhiteFilter running..");
    }
}
