package com.book.modernjavainaction.interfaces;

public class DiamondProblemFix implements A1,A2{
    public static void main(String[] args) {
        new DiamondProblemFix().hello();//RULE 3 used here, as no sub interface has this method
    }

    @Override
    public void hello() {
        System.out.println("hello local");
    }
}
