package com.educative.blind75.twopointerproblems;

public class Palindrome {
    public static void main(String[] args) {
        String[] tests = new String[]{"RACEACAR",
                "A",
                "ABCDEFGFEDCBA",
                "ABC",
                "ABCBA",
                "ABBA",
                "RACEACAR"};
        for(int i=0;i<tests.length;i++){
            palindromeCheck(tests[i]);
        }


    }
    private static void palindromeCheck(String input){
        int p1 = 0;
        int p2 = input.length()-1;
        System.out.println("CHECKING :"+input);
        for(int i=0;i<input.length();i++)
        {
            System.out.println("p1["+p1+ "] = "+input.charAt(p1)+" p2["+p2+"] = "+ input.charAt(p2) );

            if(input.charAt(p1)==input.charAt(p2)){
                System.out.println("Chars meet, moving in..");
                if(p1>=p2)
                {
                    System.out.println(input+ " ::: IS A PALINDROME\n");
                    return;
                }
            }
            else{
                System.out.println(input +" is NOT a palindrome\n");
                return;
            }
            p1++;
            p2--;
        }

    }
}
