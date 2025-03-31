package com.book.modernjavainaction.behaviorparametarization;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.color().equals(Color.GREEN);
    }
}
