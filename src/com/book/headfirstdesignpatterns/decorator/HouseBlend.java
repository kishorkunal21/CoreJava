package com.book.headfirstdesignpatterns.decorator;

public class HouseBlend extends Beverage {

    public HouseBlend(){
        description="House Blend Coffee";
    }

    @Override
    public double cost() {
        return 110.0;
    }
}
