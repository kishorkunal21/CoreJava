package com.educative.blind75.twopointerproblems;

//Given an integer array nums, find and return all unique triplets
// [nums[i], nums[j], nums[k]], where the indexes satisfy
// i ≠j, i≠k, and j≠k, and the sum of the elements nums[i] + nums[j] + nums[k] == 0

import java.util.Arrays;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] a1 = new int[]{-2,0,2,-2,1,-1};//output =[[-2,0,2],[-1,0,1]]
        int[] a2 = new int[]{-3,-1,-1,0,1,2,3,3};//output =[[-3,0,3],[-3,1,2],[-1,-1,2],[-1,0,1]]
        int[] a3 = new int[]{0,0,0,0};//output =[[0,0,0]]
        int[] a4 = new int[]{3,5,7,8};//output =[[]]

        calculate(a1, 0);
    }

    private static void calculate(int[] input, int targetSum) {

        System.out.println("Input :"+ Arrays.toString(input)+" TargetSum :"+targetSum);



    }

}

