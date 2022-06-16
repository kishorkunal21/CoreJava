package com.mosh.designpatterns.behavioural.strategy;

public class ImageStorageNA {
    private String compressor,filter;


    public ImageStorageNA(String compressor, String filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    void compress(){
        if(compressor.equalsIgnoreCase(ImageType.JPEG.toString())){
            System.out.println("Compressing using JPEG");
        }else if(compressor.equalsIgnoreCase(ImageType.PNG.toString())){
            System.out.println("Compressing using PNG");
        }
    }

    void filter(){
        if(filter.equalsIgnoreCase(FilterType.BLACK_AND_WHITE.toString())){
            System.out.println("Filtering with BLACK_AND_WHITE");
        }else if(filter.equalsIgnoreCase(FilterType.HIGH_CONTRAST.toString())){
            System.out.println("Filtering with HIGH_CONTRAST");
        }
    }

}
