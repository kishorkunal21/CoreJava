package com.mademyown;

import javax.sound.midi.SoundbankResource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomHashMap {


    public static void main(String[] args) {
        System.out.println("Kunal".hashCode() % 10);
        System.out.println(("Kunals".hashCode() % 10));
        Map<HashAndKey,String> map = new HashMap<>();
        HashAndKey h1 = new HashAndKey(1, "k1");
        HashAndKey h2 = new HashAndKey(2, "k2");
        HashAndKey h3 = new HashAndKey(2, "k2");
        HashAndKey h4 = new HashAndKey(2, "k2");

        map.put(h1, "k1");
        map.put(h2, "k2");
        map.put(h3, "k3");
        map.put(h4, "k4");
        System.out.println(map.get(h1));


    }

    private static class HashAndKey {
        int hashCode;
        String key;

        public HashAndKey(int hashCode, String key) {
            System.out.println("constructor call : "+hashCode+ " "+key);
            this.hashCode = hashCode;
            this.key = key;
        }

        public int hashCode() {
            System.out.println("Calling hashcode..");
            return this.hashCode;
        }

        public boolean equals(Object object) {
            System.out.println("Calling equals for key : " + object);
            return key.equals(object.toString());
        }


    }
}
