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
        nonConstructableChange(new int[]{6, 4, 5, 1, 1, 8, 9});


    }

    static int nonConstructableChange(int[] input){
        int min = 1;

        if(input.length>1){
            List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
            inputList = inputList.stream().sorted().collect(Collectors.toList());
            inputList.stream().forEach(System.out::println);


            for(int i=0;i<inputList.get(inputList.size()-1);i++){
                min = min+1;
                if( (inputList.get(i)+inputList.get(i+1))==min){
                    System.out.println("available :: "+(min));
                }
                else{
                    System.out.println("NOT AVAILABLE :: "+min);
                    return min;
                }
            }
        }


        return min;
    }
}
