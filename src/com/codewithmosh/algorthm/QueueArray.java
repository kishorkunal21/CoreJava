package com.codewithmosh.algorthm;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class QueueArray {

	private int[] qarray = null;
	private int index = 0;

	public int[] enqueue(int num) {

		if (index == 0) {
			qarray = new int[index + 1];
			qarray[index] = num;
			index++;
		} else {
			// 10 20
			int[] temp = new int[index + 1];
			System.arraycopy(qarray, 0, temp, 0, index);
			temp[index] = num;
			qarray = temp;
			index++;
		}
		return qarray;
	}

	public void printQueue() {
		System.out.println(Arrays.toString(qarray));
	}

	public int[] dequeue() {
		if (qarray != null) {
			int[] temp = new int[qarray.length - 1];
			System.arraycopy(qarray, 1, temp, 0, temp.length);
			qarray = temp;
			index--;
		}
		return qarray;
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
	
	public int[] priorityEnqueue(int num) {

		//30 20 10
		int [] temp = enqueue(num);
		for(int i=0;i<(temp.length-1);i++) {
			if(temp[i]>temp[i+1]) {
				int swap = temp[i];
				temp[i] =temp[i+1];
				temp[i+1]=swap;
			}
		}
		qarray=temp;
		return qarray;
	}
	

}
