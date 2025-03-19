package com.educative.blind75.twopointerproblems;

import java.util.Arrays;

/*
Does your problem match this pattern?
Yes, if all of these conditions are fulfilled:
1. Linear data structure: The input data can be traversed in a linear fashion, such as an array, linked list, or string.
2. Process pairs: Process data elements at two different positions simultaneously.
3. Dynamic pointer movement: Both pointers move independently of each other according to certain conditions or criteria. In addition, both pointers might move along the same or two different data structures.
 */
public class PairOfSumToNumberInSortedArray {
    public static void main(String[] args) {
        pairSumFinder(new int[]{2, 5, 7, 11, 13}, 14);

    }

    private static void pairSumFinder(int[] sortedArray, int targetSum) {
        int p1 = 0, p2 = sortedArray.length - 1;
        System.out.println("input array :" + Arrays.toString(sortedArray) + " SUM CHECK : " + targetSum);

        for (int i = 0; i < sortedArray.length; i++) {

            int currentSum = sortedArray[p1] + sortedArray[p2];
            System.out.println("p1 : " + sortedArray[p1] + " p2 : " + sortedArray[p2] + " sum : " + currentSum);
            if (currentSum == targetSum) {
                System.out.println("FOUND : " + sortedArray[p1] + "," + sortedArray[p2]);
                break;
            } else if (currentSum > targetSum) {
                p2--;
            } else {
                p1++;
            }
            System.out.println("Not Found");
        }

    }
}
