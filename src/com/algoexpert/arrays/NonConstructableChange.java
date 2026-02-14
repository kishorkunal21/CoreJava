package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// from a given set of inputs, find out the MIN AMOUNT OF CHANGE  that u can't create
//e.g. input[5,7,1,1,2,3,22] - change can't be created 20
// e.g. no input - change cant be created is 1
public class NonConstructableChange {


    public static void main(String[] args) {
        //nonConstructableChange(new int[]{5, 7, 1, 1, 2, 3, 22});
        //nonConstructableChange(new int[]{6, 4, 5, 1, 1, 8, 9});
        //nonConstructableChange(new int[]{4, 2, 1 });
        //nonConstructableChange(new int[]{1, 2, 5});
        //nonConstructableChange(new int[]{5, 7, 1, 1, 2, 3, 22});
        nonConstructableChange(new int[]{1, 1, 2, 3, 4, 5, 6, 9});
    }

    static int nonConstructableChange(int[] coins) {
        int min = 0;
        // logic : if the new entry is > sum +1 ; change is not possible
        List<Integer> minList = new ArrayList<>();


        if (coins.length > 1) {
            Arrays.sort(coins);
            System.out.println("sorted : " + Arrays.toString(coins));

            for (int coin : coins) {
                if (coin > (min + 1)) {
                    System.out.println("output : " + (min + 1));
                    return min + 1;
                } else {
                    min = min + coin;
                    System.out.println("coin : " + coin + "sum : " + min);
                }
            }
        }
        return 1;
    }
}
