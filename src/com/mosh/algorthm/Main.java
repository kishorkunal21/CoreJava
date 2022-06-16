package com.mosh.algorthm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		queuesPriority();
	}

	public static void queuesPriority() {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(33);
		q.add(44);
		q.add(11);
		q.add(22);	
		System.out.println(q);
		q.remove();		
		System.out.println(q);
		QueueArray qk = new QueueArray();
		qk.priorityEnqueue(20);
		qk.priorityEnqueue(30);
		qk.priorityEnqueue(10);		
		System.out.println(Arrays.toString(qk.priorityEnqueue(45)));
	}
	
	
	public static void queuesStack() {
		QueueStack qk = new QueueStack();
		qk.enqueue(10);
		qk.enqueue(20);
		qk.enqueue(30);
		qk.enqueue(45);
		qk.dequeue();
		qk.dequeue();
		qk.dequeue();
	}
	public static void queues() {

		QueueArray qk = new QueueArray();
		qk.enqueue(10);
		qk.enqueue(20);
		qk.enqueue(30);
		qk.enqueue(45);
		qk.printQueue();
		qk.dequeue();
		qk.printQueue();
		System.out.println(Arrays.toString(qk.reverseQueue()));

		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(11);
		q.add(22);
		q.add(33);
		q.add(44);
		System.out.println(q);
		q = qk.reverseQueue(q);
		System.out.println(q);
		q.remove(); // q =qk.reverseQueue(q); System.out.println(q);

	}

	public static void hashTables() {

		HashTablesImpl hk = new HashTablesImpl();
		String result = hk.searchNonIterative("a green apple");
		result = hk.firstRepeatChar("green apple");
		result = "" + hk.firstRepeatCharSet("aagreen apple");

		System.out.println(result);

		HashTables h = new HashTables();
		h.put(10, "first");
		h.put(20, "second");
		h.put(30, "third");
//		Map<Integer, String> map = new HashMap<Integer, String>();
//		map.put(1,"KK");
//		map.put(2,"Moti");
//		map.put(3,"TunTun");
//		map.put(3,"TunTun2");
//		System.out.println(map);
//		for(Entry<Integer, String> item:map.entrySet()) {
//			System.out.println(item);
//		}

	}

	public static void stacks() {

		Stacks s = new Stacks();
		s.push(50);
		s.push(40);
		s.push(30);
		s.push(20);
		s.print();
		System.out.println("Pop=" + s.pop());
		System.out.println("Peek=" + s.peek());
		s.print();
		// System.out.println(s.reverseStringStack("moti"));
		// System.out.println(s.balancedExpression("[(1+2)]"));

	}

	public static void linkedList() {
		LinkedListMosh ll = new LinkedListMosh();
		ll.addfirst(10);
		ll.addlast(20);
		ll.addlast(30);
		ll.addlast(40);
		ll.print();
		ll.reverseNodes();
		ll.print();
		// System.out.println(ll.indexOf(20));
		// ll.toArray();
		/*
		 * ll.addlast(20); ll.addlast(30); ll.addlast(40); ll.addlast(50);
		 * ll.printList(); ll.remove(30); ll.printList();
		 */
	}

	public static void array() {
		Array numbers = new Array(3);
		numbers.insert(1);
		numbers.insert(2);
		numbers.insert(3);
		numbers.insert(4);
		numbers.removeAt(4);
		numbers.print();
		System.out.println("Index : " + numbers.indexOf(3));

		linkedList();
	}

	public static void linkedListK() {
		LinkedList ll = new LinkedList();
		ll.addFirst(10);
		ll.addFirst(20);
		ll.addFirst(30);
		ll.addLast(10);

		System.out.println(ll.indexOf(30));
		System.out.println(ll.contains(30));
		System.out.println(ll);
	}

}
