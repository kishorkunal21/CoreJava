package com.book.headfirstdesignpatterns.decoratorbiryani;

public class Restaurant {
    public static void main(String[] args) {
        Biryani biryani = new HyderabadiBiryani();
        System.out.println(biryani.description+" "+ biryani.cost());
        biryani = new KababAlaKarate(biryani);
        System.out.println(biryani.getDescription()+" "+ biryani.cost());
        biryani = new TandooriAlaKarate(biryani);
        System.out.println(biryani.getDescription()+" "+ biryani.cost());
    }
}
