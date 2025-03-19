package com.educative.blind75.twopointerproblems;

import com.codewithmosh.algorthm.Array;

import java.util.Arrays;

public class ReverseArrayInPlace {
    public static void main(String[] args) {
        reverse(new int[]{1, 2, 3, 4, 5});
    }

    private static void reverse(int[] input) {
        int p1 = 0, p2 = input.length - 1;
        System.out.println(Arrays.toString(input));
        for (int i = 0; i < input.length; i++) {
            int temp = input[p1];
            input[p1] = input[p2];
            input[p2] = temp;
            p1++;
            p2--;
            if (p1 >= p2)
                break;
        }
        System.out.println("Reversed as :" + Arrays.toString(input));
    }

}
