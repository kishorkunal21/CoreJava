package com.mademyown;


import java.util.List;

public class Main  {

    public static void main(String[] args) {

        CustomImmutableClass customImmutableClass = new CustomImmutableClass(1, "kk"
        , List.of("e1","e2"));
        System.out.println(customImmutableClass);
        CustomImmutableClass customImmutableClass2 = new CustomImmutableClass(1, "kk2"
        ,List.of("e1","e2"));
        customImmutableClass=customImmutableClass2;
        System.out.println(customImmutableClass);

    }
}
