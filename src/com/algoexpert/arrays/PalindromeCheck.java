package com.algoexpert.arrays;

import java.util.Arrays;

public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println("abcba : "+(isPalindrome("abcba")));
        System.out.println("a : "+(isPalindrome("a")));
        System.out.println("ab : "+(isPalindrome("ab")));
        System.out.println("abb : "+(isPalindrome("abb")));
        System.out.println("abcdefghhgfedcba : "+(isPalindrome("abcdefghhgfedcba")));
        System.out.println("abcdefghihgfedcba : "+(isPalindrome("abcdefghihgfedcba")));
        System.out.println("abcdefghihgfeddcba : "+(isPalindrome("abcdefghihgfeddcba")));
        System.out.println("=========isPalindromeOptimised====================");

        System.out.println("abcba : "+(isPalindromeOptimised("abcba")));
        System.out.println("a : "+(isPalindromeOptimised("a")));
        System.out.println("ab : "+(isPalindromeOptimised("ab")));
        System.out.println("abb : "+(isPalindromeOptimised("abb")));
        System.out.println("abcdefghhgfedcba : "+(isPalindromeOptimised("abcdefghhgfedcba")));
        System.out.println("abcdefghihgfedcba : "+(isPalindromeOptimised("abcdefghihgfedcba")));
        System.out.println("abcdefghihgfeddcba : "+(isPalindromeOptimised("abcdefghihgfeddcba")));

    }

    public static boolean isPalindrome(String str) {

        int p1 = 0;
        int p2 = str.length() - 1;
        String[] strArr = str.split("");
        //System.out.println("p1 :" + p1 + " p2 : " + p2 + " " + Arrays.toString(strArr));

        while (p1 < p2) {
            if (strArr[p1].equalsIgnoreCase(strArr[p2])) {
                // System.out.println("p1 :" + strArr[p1]  + " p2 : " + strArr[p2]  );
                p1++;
                p2--;
            } else {
                //      System.out.println("p1 :" + strArr[p1]  + " p2 : " + strArr[p2]  );
                return false;
            }
        }


        return true;
    }

    public static boolean isPalindromeOptimised(String str) {
        /*Unnecessary space usage: Converting to a String[] with split("") uses O(n) extra space. You can compare characters directly from the original string.
        Slower comparison: Using equalsIgnoreCase() on strings is slower than comparing char primitives directly.
        Missing edge cases: If the problem requires ignoring spaces/special characters, this won't handle that.*/
        int p1 = 0;
        int p2 = str.length() - 1;
        //System.out.println("p1 :" + p1 + " p2 : " + p2 + " " + Arrays.toString(strArr));

        while (p1 < p2) {
            if (Character.toLowerCase(str.charAt(p1)) != Character.toLowerCase(str.charAt(p2))) {
                return false;
            } else {
                p1++;
                p2--;
            }
        }
            /*
            * Improvements:
            O(1) space complexity instead of O(n)
            Faster character comparison
            More readable
            Same O(n) time complexity
            * */

        return true;
    }


}
