package com.book.headfirstdesignpatterns.decorator;

public class MochaCondiment extends CondimentDecorator{

    private static double addonCost=  11.5;
    public MochaCondiment(Beverage beverage){
        System.out.println("++ Mocha $"+addonCost);
        this.beverage=beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+addonCost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +": Mocha";
    }
}
