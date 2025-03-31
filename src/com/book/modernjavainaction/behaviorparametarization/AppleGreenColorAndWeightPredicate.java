package com.book.modernjavainaction.behaviorparametarization;

public class AppleGreenColorAndWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.color().equals(Color.GREEN) && apple.weight()>150;
    }
}
