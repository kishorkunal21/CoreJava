package com.educative.blind75.twopointerproblems;

//Given an integer array nums, find and return all unique triplets
// [nums[i], nums[j], nums[k]], where the indexes satisfy
// i ≠j, i≠k, and j≠k, and the sum of the elements nums[i] + nums[j] + nums[k] == 0

import java.util.*;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[][] a1 = {{-2, 0, 2, -2, 1, -1},//output =[[-2,0,2],[-1,0,1]]
                {-3, -1, -1, 0, 1, 2, 3, 3},//output =[[-3,0,3],[-3,1,2],[-1,-1,2],[-1,0,1]]
                {0, 0, 0, 0},//output =[[0,0,0]]
                {3, 5, 7, 8}};//output =[[]]
        for (int[] item : a1) {
            calculate(item, 0);
        }
        /*Set<Integer> set = new HashSet<>();
        set.add(Integer.valueOf(1));
        set.add(1);
        set.forEach(System.out::println);*/
    }

    private static void calculate(int[] input, int targetSum) {

        System.out.println("before sorting : " + Arrays.toString(input));
        Arrays.sort(input);
        System.out.println("after sorting : " + Arrays.toString(input));

        Set<int[]> set = new HashSet<>();


        for (int pivot : input) {
            int low = 1, high = input.length - 1;
            if(pivot>targetSum){
                break;
            }
            while (low<high){
                int sum = pivot + input[low] + input[high];
                System.out.println("current :" + pivot + " p1 :" + input[high] + " p2:" + input[high] + " SUM :" + sum);
                if(sum==targetSum){
                    int[] triplet = new int[]{pivot,input[low],input[high]};
                    set.add(triplet);
                    System.out.println("Added : "+Arrays.toString(triplet));
                    low++;
                    high--;
                    while (low < high && input[low] == input[low - 1]) {
                        low++;
                    }
                    while (low < high && input[high] == input[high + 1]) {
                        high--;
                    }
                } else if (sum<targetSum) {
                    low++;
                } else {
                    high--;
                }
            }
            System.out.println("## NEXT PIVOT");

        }

        set.forEach((a) -> System.out.println(Arrays.toString(a)));

        System.out.println("***********\n");


    }

}

