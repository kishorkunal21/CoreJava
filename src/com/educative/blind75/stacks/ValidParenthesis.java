package com.educative.blind75.stacks;

import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "(){}[]";
        check(s);
    }

    private static void check(String input) {
        Stack<String> stack = new Stack<>();
        for (String s : input.split("")) {
            if ("})]".contains(s)) { //implement this using a HashMap and check efficiency
                if(stack.isEmpty()){
                    System.out.println("INVALID !");
                    return;
                }else{
                    stack.pop();
                }
            } else if ("{([".contains(s)) {
                stack.push(s);
            }
            System.out.println("STACK : "+stack);
        }
        System.out.println("VALID");


    }
}
