package com.book.headfirstdesignpatterns.decorator;

public class Expresso extends Beverage{

    public Expresso(){
        description = "Expresso";
    }

    @Override
    public double cost() {
        return 125.0;
    }
}
