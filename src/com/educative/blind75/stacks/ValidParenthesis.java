package com.educative.blind75.stacks;

import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String[] s = {"(){}[]","(){[{()}]}","))){{}}}]]","()"};
        Arrays.stream(s).forEach(ValidParenthesis::checkUsingHasMap);
    }

    private static void checkUsingHasMap(String input) {
        Map<String,String> map = new HashMap<>();
        map.put("]", "[");
        map.put(")", "(");
        map.put("}", "{");

        Stack<String> stack = new Stack<>();
        for (String s : input.split("")) {
            if (map.containsKey(s)) { //if closing is found, POP the opening of it
                if(stack.isEmpty()){
                    System.out.println("Input : "+ input +" is INVALID");
                    System.out.println("--------------------------");
                    return;
                }else{
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
            //System.out.println("STACK : "+stack);
        }
        System.out.println("Input : "+ input +" is VALID");
        System.out.println("--------------------------");


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
