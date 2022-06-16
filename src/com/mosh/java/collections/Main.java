package com.mosh.java.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import com.mosh.java.generics.GenericList;

public class Main {

	public static void main(String[] args) {
		
		Map<String,Books> map = new HashMap<String, Books>();
		map.put("a",new Books("malgudi days", "r k narayan"));
		map.put("b",new Books("the fountainhead", "ayan rand"));
		map.put("c",new Books("rip it up", "richard"));
		
		System.out.println(map.get("a"));
		System.out.println(map.getOrDefault("K", new Books("unknown", "unknown")));//return default
		System.out.println(map.containsKey("K"));
		map.replace("c", new Books("rip it up 2", "richard"));
		System.out.println(map.get("c"));
		
		for(String key:map.keySet())//get keys
			System.out.println(key);
		
		for(Books value:map.values())//get values
			System.out.println(value);
		
		for(Entry<String, Books> key:map.entrySet())//get both
			System.out.println(key);
		
	}

	void set() {

		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("c");//no duplicate
		System.out.println(set);
		
		Collection<String> collection = new ArrayList<String>();
		Collections.addAll(collection, "a", "b","c");
		Set<String> set1 = new HashSet<>(collection);//pass collection
		System.out.println(set1);
		
		Set<String> set2 = new HashSet<>(Arrays.asList("a","b","d"));//pass list
		System.out.println(set2);
		
		set1.addAll(set2);//add collection/set/list ? wildcard here :UNION OPERATION
		System.out.println(set1);
		
		set1.retainAll(set2);//add collection/set/list ? wildcard here :INTERSACTION OPERATION
		System.out.println(set1);
		
		set1.removeAll(set2);//add collection/set/list ? wildcard here :DIFFERENCE OPERATION
		System.out.println(set1);
	
	}
	void queue() {		
		Queue<String> queue = new ArrayDeque<String>();
		queue.add("c");
		queue.add("a");
		queue.add("b");
		queue.offer("d");//if queue is full it will not throw exception
		System.out.println(queue);
		System.out.println("queue.peek() : "+queue.peek());//start element //return null if queue is empty
		System.out.println("queue.element() : "+queue.element());//start element / will throw exception if queue is empty
		queue.remove();
		System.out.println("queue.remove() :"+queue);
	
	}
	// list sorting
	void comparabale_comparator() {

		List<Books> books = new ArrayList<Books>();
		books.add(new Books("malgudi days", "r k narayan"));
		books.add(new Books("the fountainhead", "ayan rand"));
		System.out.println(books);
		Collections.sort(books);
		System.out.println(books);
		Collections.sort(books, new AuthorComparator());
		System.out.println(books);
	}

	void list() {

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add(0, "-1");
		Collections.addAll(list, "e", "a");
		System.out.println("list=" + list);
		list.set(1, "-2");
		System.out.println("list[1]=" + list.get(1));
		list.remove(0);
		System.out.println("list=" + list);
		System.out.println("list.indexOf=" + list.indexOf("a"));
		System.out.println("list.lastIndexOf=" + list.lastIndexOf("a"));
		System.out.println("list.subList=" + list.subList(0, 2));

	}

	void collection() {

		Collection<String> collection = new ArrayList<String>();
		collection.add("a");
		collection.add("b");
		collection.add("c");
		Collections.addAll(collection, "aa", "bb", "cc");// add all at one go : UTIL CLASS

		System.out.println("collection = " + collection);
		System.out.println("collection.size() = " + collection.size());
		System.out.println("collection.contains() = " + collection.contains("aa"));
		collection.clear();
		System.out.println("collection.size() = " + collection.size());
		System.out.println("collection.isEmpty() = " + collection.isEmpty());

		Collection<String> other = new ArrayList<String>();
		other.addAll(collection);

		System.out.println("compare objects :" + (collection == other));
		System.out.println("compare value :" + (collection.equals(other)));

	}

	void iterable() {
		GenericList<String> list = new GenericList<String>();
		list.add("a");
		list.add("b");
		// Iterator iterates the objects which implements Iterable
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// foreach internally gets converted to Iterator on compilation
		for (String s : list) {
			System.out.println(s);
		}
	}

}
