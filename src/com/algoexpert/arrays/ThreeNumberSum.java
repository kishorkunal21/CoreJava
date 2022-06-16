package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] input = new int[]{12,3,1,2,-6,5,-8,6};
        threeNumberSum(input,0);
    }
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        ArrayList<Integer[]> num_list = new ArrayList<>();

        Arrays.sort(array);
        int num1, num2, num3 =0;
        for(int i=0;i<array.length;i++){
            //System.out.println("i :: "+array[i]);
            for(int j=i+1;j<array.length;j++){
                //System.out.println("j :: "+array[j]);
                for(int k=j+1;k<array.length;k++){
                    System.out.println("i:: "+array[i]+" j:: "+array[j]+" k:: "+array[j]+":::"+(array[i]+array[j]+array[k])+":::"+targetSum);
                    if(array[i]+array[j]+array[k]==targetSum){
                        System.out.println("["+array[i]+","+array[j]+","+array[k]+"]");
                        num_list.add(new Integer[]{array[i],array[j],array[k]});
                    }
                }
            }

        }
    return num_list;
}
}
