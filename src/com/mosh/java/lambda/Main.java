package com.mosh.java.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

	public static void main(String[] args) {
		// labmda types -
		// consumer : single argument no result - void test(obj o)
		// supplier : Object output no input - Obj test()
		// function : Obj map(obj) : map value to another value
		// predicate : bool test(condition) - return boolean
		
		//combining operations
		BinaryOperator<Integer> bo = (x,y)->x+y;
		Function<Integer, Integer> sqr = x->x*x;
		System.out.println(bo.apply(2, 3));
		System.out.println(sqr.apply(5));
		System.out.println(bo.andThen(sqr).apply(2, 3));
		
		UnaryOperator<Integer> square = x->x*x;
		UnaryOperator<Integer> increment = x->x+1;
		System.out.println(increment.andThen(square).apply(1));
		
		
	}
	
	private void predicate() {
		Predicate<String> lenMOreThan5 = str->str.length()>5;
		System.out.println(lenMOreThan5.test("Kunal"));
		
		
		//combining predicates
		Predicate<String> left = str ->str.startsWith("{");
		Predicate<String> right = str ->str.startsWith("}");
		Predicate<String> leftAndright=left.and(right);
		System.out.println(leftAndright.test("{omi}"));
		
		Predicate<String> leftOright=left.or(right);
		System.out.println("leftOright :"+leftOright.test("{omi}"));
		
		
		System.out.println("leftOright negate :"+leftOright.negate().test("{omi}"));
	}

	private void function() {
		// 1st param is input and 2nd is operation done on 1st and return as output
		Function<String, Integer> fun = str -> str.length();
		System.out.println(fun.apply("Kunal"));
		
		Function<String, String> f1 = str->str.replace(":","=");
		Function<String, String> f2 = str->"{"+str+"}";
		
		System.out.println(f1.andThen(f2).apply("key:value"));
	}

	private void supplier() {
		Supplier<Double> supplier = () -> Math.random();
		double random = supplier.get();
		System.out.println(random);
	}

	private void consumer_interface() {
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 1, 2, 3, 4, 5);

		for (int i : list)
			System.out.println(i);

		// using consumer interface
		list.forEach(item -> {
			System.out.println(item);
		});

		// chaining consumer
		Consumer<Integer> list1 = item -> {
			System.out.println((item));
		};
		Consumer<Integer> doubleList = item -> {
			System.out.println((item * 2));
		};

		list.forEach(list1.andThen(doubleList));
	}

	private void lambda() {

		sum(Main::referanceMethod);

		// using lambda : remove functional interface
		greet((String s) -> {
			System.out.println(s);
		});

		sum((int x, int y) -> {
			System.out.println((x * y));
		});

		// same output using Anonymous inner class
		greet(new Printer() {

			@Override
			public void print(String s) {
				System.out.println(s);

			}
		});
		// using class that implements printer interface [functional interface]
		greet(new ConsolePrinter());

	}

	public static void referanceMethod(int x, int y) {
		System.out.println((x + y));
	}

	static void sum(Sum sum) {
		sum.sum(5, 10);
	}

	static void greet(Printer printer) {
		printer.print("Hello world");
	}

}
