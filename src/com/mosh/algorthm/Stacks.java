package com.mosh.algorthm;

import java.util.Arrays;
import java.util.Stack;

public class Stacks {
	
	private int index=0;
	private static int [] stackArr = new int[1];
	
	public void push(int input) {
		
		if(index==0) {
			stackArr[0]=input;
			index++;
		}
		else {
			int [] temp = new int[index+1];
			for(int i=0;i<index;i++) {
				temp[0]=input;
				temp[i+1]=stackArr[i];
			}
			stackArr=temp;
			index++;
		}		
	}
	public int pop() {
		int pop=stackArr[0];
		int [] temp = new int[stackArr.length-1];
		for(int i=0;i<(stackArr.length-1);i++) {
			temp[i]=stackArr[i+1];
		}
		stackArr=temp;
		index--;
		
		return pop;
	}
	public int peek() {
		return stackArr[0];
	}
	public void print() {
		System.out.println(Arrays.toString(stackArr));
		/*
		 * for(int i:stackArr) { System.out.println(i); }
		 */
	}
	
	public String reverseString(String text) {
		String temp="";
		
		for(int i =(text.length()-1);i>=0;i--) {
			char s = text.charAt(i);
			temp=temp.concat(Character.toString(s));
		}
		return temp;
	}
	public String reverseStringStack(String text) {
		
		Stack<Character> stack =new Stack<Character>();
		StringBuffer temp=new StringBuffer();
		for(char c:text.toCharArray()) {
			stack.push(c);
		}
		while(!stack.empty()) {
			temp.append(stack.pop());
		}
		return temp.toString();
	}
	public String balancedExpression(String text) {
		
		String result="balanced";
		Stack<Character> stack =new Stack<Character>();
		int counter=0;
		System.out.println("counter="+counter);
		for(char c:text.toCharArray()) {
			if(c=='<'||c=='('||c=='['||c=='{'||c=='<') 
				stack.push(c);
			else if(c=='>'||c==')'||c==']'||c=='}'||c=='>')
			{
				counter=counter+1;
				System.out.println("counter="+counter);
				while(!stack.empty()) {
					char pop= stack.pop();

					if(!((pop=='<' && c=='>')||(pop=='(' && c==')')||(pop=='[' && c==']')||(pop=='{' && c=='}'))) {
						return "Not Balanced";
					}						
					else {
						counter=counter-1;
						System.out.println("counter--"+counter);
						break;
					}
				}
				if(!(stack.size()==0 && counter==0))
					result= "Not Balanced";
			}
			
			
		}
		
		return result;
	}

}
