package com.codewithmosh.designpatterns.behavioural.strategy;

public class PNGCompressor implements Compressor{
    @Override
    public void compress() {
        System.out.println("PNG Compressor running...");
    }
}
