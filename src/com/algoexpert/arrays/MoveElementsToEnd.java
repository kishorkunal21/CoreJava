package com.algoexpert.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MoveElementsToEnd {


    // move elements to the end
    // better solution - move within the same array with O(n) time complexity
    static List<Integer> betterSolution(List<Integer> array, int toMove){
        // 2,1,2,2,2,2,3,4,2

        List<Integer> result = new ArrayList<>();

        int p1 = 0;
        int p2 = array.size()-1;

        while(p2>=p1){
            System.out.println("p1 : "+p1+" p2 :"+p2+" "+ array.get(p1)+" "+array.get(p2));

            if(array.get(p2)==toMove){
                p2--;
            }
            else {
                if(array.get(p1)==toMove ){
                    System.out.println("swapping : "+array);
                    int temp = array.get(p2);
                    array.set(p2, array.get(p1));
                    array.set(p1, temp);

                    System.out.println(array+"\n");
                }
                p1++;
            }

        }
        System.out.println(array);
        return result;
    }

    static List<Integer> moveElementsToEnd(List<Integer> array, int toMove){

        List<Integer>  result =  new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(Integer n :array){
            if(n==toMove){
                stack.push(n);
            }
            else
                result.add(n);
        }
        for(Integer i:stack){
            result.add(i);
        }
        System.out.println(result);

        return result;

    }

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(new Integer[]{2,1,2,2,2,2,3,4,2});
        List<Integer> list = Arrays.asList(new Integer[]{2, 1, 2, 2, 2, 3, 4, 2});

        //moveElementsToEnd(list,2);
        betterSolution(list,2);
    }
}
