package com.mosh.designpatterns.behavioural.strategy;

// Strategy is similar to State - but in this case we separate the tasks to separate classes
// unlike State wherein all classes have the same state - mouse up and mouse down
public class Main {
    public static void main(String[] args) {
        JPEGCompressor jpegCompressor = new JPEGCompressor();
        BlackAndWhiteFilter blackAndWhiteFilter  = new BlackAndWhiteFilter();
        ImageStorage imageStorage = new ImageStorage(jpegCompressor,blackAndWhiteFilter);
        imageStorage.filter();
        imageStorage.compress();

        imageStorage.store("File",jpegCompressor,blackAndWhiteFilter);

    }
}
