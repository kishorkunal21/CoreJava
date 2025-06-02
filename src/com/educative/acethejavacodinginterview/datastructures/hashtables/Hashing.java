package com.educative.acethejavacodinginterview.datastructures.hashtables;

import java.util.Arrays;

//https://www.educative.io/module/page/Z4JLg2tDQPVv6QjgO/10370001/6546848606322688/6032520048279552
// following are the hashing algorithms to get index
//TODO : verify
public class Hashing {
    public static void main(String[] args) {
        System.out.println("Index for Key 25 and TableSize 16 : " + arithmeticModular(25, 16));
        System.out.println("Index for Key 123456 and TableSize 100 : " + truncation(123456, 100));
        System.out.println("Index for Key 456789 and with chunks of 2 : " + folding(456789, 2));

    }

    private static int arithmeticModular(int key, int tableSize) {
        return key % tableSize;
    }

    private static int truncation(int key, int tableSize) {
        return key % tableSize;
    }

    private static int folding(int key, int chunks) {
        System.out.println("----------------------");
        String strKey = String.valueOf(key);
        int sum = 0;
        int p1 = 0;
        for (int i = 0; i <= chunks; i++) {
            if(p1<strKey.length()){
                int c = Integer.parseInt(strKey.substring(p1,p1+chunks));
                System.out.println(c);
                sum += c;
                p1+=chunks;
            }
        }
        System.out.println(sum);
        return sum;
    }

}
