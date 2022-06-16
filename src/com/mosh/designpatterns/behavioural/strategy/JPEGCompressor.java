package com.mosh.designpatterns.behavioural.strategy;

public class JPEGCompressor implements Compressor{
    @Override
    public void compress() {
        System.out.println("JPEG Compressor running...");
    }
}
