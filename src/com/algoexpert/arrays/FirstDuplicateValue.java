package com.algoexpert.arrays;

// find first duplicate value that comes in sequence
// [2,1,5,2,3,3,4] - first is 2, 3 is also there, but it comes after 2 in index


import java.util.Arrays;

public class FirstDuplicateValue {

    public static int findFirstDuplicateValue(int[] array){

        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        for(int i=0;i<array.length-1;i++){
            if(array[i]==array[i+1]){
                return array[i];
            }
        }

        return -1;
    }

    public static int findFirstDuplicateValueFailedSolution(int[] array){

        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        for(int i=0;i<array.length-1;i++){
            if(array[i]==array[i+1]){
                return array[i];
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(findFirstDuplicateValue(new int[]{2,1,5,2,3,3,4}));
    }
}
