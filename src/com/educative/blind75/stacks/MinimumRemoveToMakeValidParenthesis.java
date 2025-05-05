package com.educative.blind75.stacks;

import java.util.*;
//https://www.educative.io/module/page/k5m3gACX33xvNPEvB/10370001/5966164452442112/5200684041109504
public class MinimumRemoveToMakeValidParenthesis {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("m)no(q)rs(", "mno(q)rs", ")((yz)())(", "((yz)())",
                "ab)cca(spo)(sc(s)(", "abcca(spo)sc(s)");

        map.forEach((k, v) -> System.out.println("TESTED : "+minRemove(k).equalsIgnoreCase(v)));


    }

    private static String minRemove(String input) {

        System.out.println("--------------------------");
        Map<String, String> map = new HashMap<>();
        map.put("]", "[");
        map.put(")", "(");
        map.put("}", "{");

        StringBuilder index = new StringBuilder();
        Set<String> braces = new HashSet<>(Arrays.asList("{", "(", "[", "]", "}", ")"));

        Stack<String> stack = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        int current = 0;
        for (String s : input.split("")) {
            if (map.containsKey(s)) { //if closing is found, POP the opening of it
                if (!stack.isEmpty()) {
                    stack.pop();
                    stackIndex.pop();
                } else {
                    stack.push(s);
                    stackIndex.push(current);
                }
            } else {
                if (braces.contains(s)){
                    stack.push(s);
                    stackIndex.push(current);
                }
            }
            current++;
            //System.out.println("STACK : "+stack);
        }
        System.out.println("Input : " + input + " has extras at " + stackIndex);
        StringBuilder output = new StringBuilder(input);
        int counter =0;
        for(int i:stackIndex){
                output.deleteCharAt(i-counter);
                counter++;//counter is to keep track of shrunk string
        }
        System.out.println("output : "+output);
        return output.toString();

    }
}
