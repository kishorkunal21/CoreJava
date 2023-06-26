package com.algoexpert.arrays;

import java.util.*;


// find smallest diffrent from given set of 2 arrays and return 1st array
// element and corresponding 2nd one. NOTE - diff should be based on number line
// like diff between -5 and 5 will be 10 and -5 and -4 is 1
public class SmallestDifference {


    public static int[] smallestDifference(int[] arrayone, int[] arraytwo){
        System.out.println(Arrays.toString(arrayone)+Arrays.toString(arraytwo));
/*
        int[] merged=new int[arrayone.length+arraytwo.length];
        int min=0;
        System.arraycopy(arrayone, 0, merged, 0, arrayone.length);
        System.arraycopy(arraytwo, 0, merged, arrayone.length, arraytwo.length);
        System.out.println(Arrays.toString(merged));
        Arrays.sort(merged);
        System.out.println("merged "+Arrays.toString(merged));
*/
        Arrays.sort(arrayone);
        Arrays.sort(arraytwo);
        System.out.println(Arrays.toString(arrayone)+Arrays.toString(arraytwo));


        int lowest = 0;
        int[] result = new int[2];
        for(int i=0;i<arrayone.length;i++){
            for(int j=0;j<arraytwo.length;j++){
                int diff = Math.abs(arrayone[i]-arraytwo[j]);
                System.out.println(arrayone[i]+" "+arraytwo[j]+" "+diff+" "+lowest);

                if(lowest==0 || diff<lowest){
                    lowest=diff;
                    result[0]=arrayone[i];
                    result[1]=arraytwo[j];
                    if(diff==0)break;
                }
            }
            if(lowest==0)break;
        }
        System.out.println(lowest+" "+Arrays.toString(result));

        return result;


    }

    public static void main(String[] args) {
        SmallestDifference.smallestDifference(
                new int[]{10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123, 530},
                new int[]{-1441, -124, -25, 1014, 1500, 660, 410, 245, 530});
    }
}
