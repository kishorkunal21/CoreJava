package com.book.headfirstdesignpatterns.decoratorbiryani;

public class TandooriAlaKarate extends AlaKarate {
    public TandooriAlaKarate(Biryani biryani){
        this.biryani=biryani;
        System.out.println("Adding tandoori 150");
    }
    @Override
    public double cost() {
        return biryani.cost()+ 150;
    }

    @Override
    public String getDescription() {
        return biryani.getDescription()+" + Tandoori";
    }
}
