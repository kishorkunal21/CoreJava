package com.book.headfirstdesignpatterns.decorator;

public class WhipCondiment extends CondimentDecorator{

    private static double addonCost=  7.5;
    public WhipCondiment(Beverage beverage){
        System.out.println("++ Whip $"+addonCost);
        this.beverage=beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+addonCost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +": Whip";
    }
}
