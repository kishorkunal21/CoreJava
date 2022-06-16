package com.mosh.designpatterns.behavioural.strategy;

public class ImageStorage {

    private Compressor compressor;
    private Filter filter;

    public ImageStorage(Compressor compressor,Filter filter){
        this.compressor = compressor;
        this.filter = filter;
    }

    public ImageStorage(){
    }

     void compress(){
        compressor.compress();
     }

     void filter(){
        filter.filter();
     }

     void store(String filename, Compressor compressor,Filter filter){
         System.out.println("Storing "+filename);
         compressor.compress();
         filter.filter();
     }

}
