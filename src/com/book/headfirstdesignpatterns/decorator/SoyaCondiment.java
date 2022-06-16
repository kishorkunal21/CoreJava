package com.book.headfirstdesignpatterns.decorator;

public class SoyaCondiment extends CondimentDecorator{

    private static double addonCost=  13.5;
    public SoyaCondiment(Beverage beverage){
        System.out.println("++ Soya $"+addonCost);
        this.beverage=beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+addonCost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +": Soya";
    }
}
