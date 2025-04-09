package com.educative.blind75.twopointerproblems;

import java.util.Arrays;

/*
You’re given an integer array, arr.
Return a resultant array so that res[i]
is equal to the product of all the elements of arr except arr[i].
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[][] arr = {{2, 4, 0, 6},//[0,0,48,0]
                {1, -3, 5, 7, 11}//[1155, -385, 231,165,-105]
        };
        for (int[] i : arr) {
            calculateNaiveApproach(i);
        }

    }

    //should be O(n) time with O(1) space
    private static void calculateNaiveApproach(int[] arr) {
        int[] result = new int[arr.length];
        System.out.println("INPUT : " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int m = 1;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    m = m * arr[j];
                }
            }
            result[i] = m;
        }

        System.out.println("FINAL : "+Arrays.toString(result));
    }

    /*
    The idea is that we can break down the problem into two parts: the product of elements to the left of each index and the product of elements to the right of each index. By maintaining two separate running products as we traverse the array from both ends, we can accumulate the product values to populate the res array. This approach eliminates the need for repeated multiplications and effectively calculates the product except for the element at the current index. The Two Pointers pattern is employed here to handle both the left and right products in a single traversal
     */
    private static void optimisedApproachCalculate(int[] arr){
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);
        int left = 0,right=arr.length-1;


        while (left<arr.length && right>-1){

            left++;
            right--;
        }
    }

}
