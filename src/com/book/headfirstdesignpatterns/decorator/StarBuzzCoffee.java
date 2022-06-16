package com.book.headfirstdesignpatterns.decorator;

public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Expresso();
        System.out.println(beverage.getDescription() + " $"+beverage.cost());

        Beverage darkroast = new DarkRoast();
        System.out.println(darkroast.getDescription() + " $"+darkroast.cost());
        darkroast = new MochaCondiment(darkroast);
        darkroast = new WhipCondiment(darkroast);
        darkroast = new SoyaCondiment(darkroast);
        System.out.println(darkroast.getDescription() + " $"+darkroast.cost());

    }
}
