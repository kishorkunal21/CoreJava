package com.book.headfirstdesignpatterns.decorator;

public class Decaf extends Beverage {

    public Decaf(){
        description="House Blend Coffee";
    }

    @Override
    public double cost() {
        return 105.0;
    }
}
