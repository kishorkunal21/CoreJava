package com.book.headfirstdesignpatterns.decorator;

public class DarkRoast extends Beverage {

    public DarkRoast(){
        description="Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 135.0;
    }
}
