package com.codewithmosh.misc;

public class Misc implements A2,A1 {
    public static void main(String[] args) {
        String s ="my name is kunal";

        Misc misc = new Misc();
        misc.m1();




        //string override
        misc.s1(12);



    }

    void s1(String s){
        System.out.println("String");
    }
    void s1(Object o){
        System.out.println("String");
    }

    @Override
    public void m1() {
        A2.super.m1();
    }
}
