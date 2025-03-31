package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSumImprovised {
    public static void main(String[] args) {
        int[] input = new int[]{12,3,1,2,-6,5,-8,6};
        //output : [[-8,2,6],[-8,3,5],[-6,1,5]]

        threeNumberSum(input,0).
                forEach(a-> System.out.print(Arrays.toString(a)));

    }
    public static List<int[]> threeNumberSum(int[] input, int targetSum) {
        ArrayList<int[]> result = new ArrayList<>();
        System.out.println("INPUT :"+Arrays.toString(input));
        Arrays.sort(input);
        System.out.println("SORTED :"+Arrays.toString(input));

        for(int i=0;i<input.length-2;i++){
            int left=i+1,right=input.length-1;
            while (left<right){
                int sum = input[i]+input[left]+input[right];
                System.out.printf("[%d,%d,%d] : %d\n",input[i],input[left],input[right],sum);
                if(sum==targetSum){
                    result.add(new int[]{input[i],input[left],input[right]});
                    System.out.println("Added ["+input[i]+", "+ input[left]+", "+input[right]+"]");
                    left++;
                    right--;
                } else if (sum<targetSum) {
                    left++;
                }else  {
                    right--;
                }
            }
break;
        }


    return result;
}
}
