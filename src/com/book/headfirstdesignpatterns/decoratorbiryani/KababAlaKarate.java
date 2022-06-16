package com.book.headfirstdesignpatterns.decoratorbiryani;

public class KababAlaKarate extends AlaKarate {
    public KababAlaKarate(Biryani biryani){
        this.biryani=biryani;
        System.out.println("Adding Kabab 180");
    }
    @Override
    public double cost() {
        return biryani.cost()+ 180;
    }

    @Override
    public String getDescription() {
        return biryani.getDescription()+" + Kabab";
    }
}
