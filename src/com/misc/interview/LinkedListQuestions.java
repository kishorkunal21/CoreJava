package com.misc.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class LinkedListQuestions {

	public static void main(String[] args) {
		LinkedList<String> llist = new LinkedList<String>();
		llist.add("kk1");
		llist.add("kk2");
		llist.add("kk3");
		llist.add("kk4");
		llist.add("kk5");
		llist.add("kk6");
		llist.add("kk7");
		llist.add("kk8");
		llist.add("kk9");
		llist.add("kk10");
		reverseLinkedList(llist);
	}

	static void reverseLinkedList(LinkedList<String> llist) {
		System.out.println(Arrays.toString(llist.toArray()));
		Stack<String> stack = new Stack<String>();
		for (String i : llist) {
			stack.push(i);
		}
		llist.clear();
		System.out.println("Stack = " + Arrays.toString(stack.toArray()));
		while (!stack.empty()) {
			llist.add(stack.pop());
		}

		System.out.println("Reversed linked list - " + Arrays.toString(llist.toArray()));

	}

	static void reverseLinkedListIndex(LinkedList<String> llist, int n) {
		System.out.println(Arrays.toString(llist.toArray()));

		int slots = llist.size() % n;
		if (llist.size() % n != 0)
			slots++;
		System.out.println(n + " " + llist.size() + " " + slots);

		Stack<String> stack = new Stack<String>();
		for (String i : llist) {
			stack.push(i);
		}
		llist.clear();
		System.out.println("Stack = " + Arrays.toString(stack.toArray()));
		while (!stack.empty()) {
			llist.add(stack.pop());
		}

		System.out.println("Reversed linked list - " + Arrays.toString(llist.toArray()));

	}

}
