package com.codewithmosh.algorthm;

import java.util.Queue;
import java.util.Stack;

public class QueueStack {

	private int[] qarray = null;
	private int index = 0;

	private Stack<Integer> stack = new Stack<Integer>();;
	private Stack<Integer> stackTemp = new Stack<Integer>();;

	public void enqueue(int num) {
		stack.push(num);
		System.out.println(stack);
	}

	public void dequeue() {
		while (!stack.isEmpty())
			stackTemp.push(stack.pop());
		stackTemp.pop();
		while (!stackTemp.isEmpty())
			stack.push(stackTemp.pop());
		System.out.println(stack);
	}

	public int[] reverseQueue() {
		if (qarray != null) {
			int[] temp = new int[qarray.length];
			for (int i = 0; i < temp.length; i++)
				temp[i] = qarray[(qarray.length - 1) - i];
			qarray = temp;
		}
		return qarray;

	}

	// reverse queue using stack
	public Queue<Integer> reverseQueue(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<Integer>();
		while (!queue.isEmpty())
			stack.push(queue.remove());
		System.out.println("Stack " + stack);
		while (!stack.isEmpty())
			queue.add(stack.pop());

		return queue;
	}

}
