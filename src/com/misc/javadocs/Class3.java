package com.misc.javadocs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Class3 extends Class2 implements Bikes {

	public static void main(String[] args) {

		// check((h, l) -> h.(l).isempty(), 5);

		ExecutorService service = Executors.newFixedThreadPool(10);
		service.submit(() -> 1);

		List<Number> list = new ArrayList<Number>();
		list.add(new Integer(10));
		list.add(20);

		Collections.reverse(list);
		for (Object o : list) {
			System.out.println(o);
		}
//
//		Iterator<Integer> i = list.iterator();
//
//		while (i.hasNext()) {
//			System.out.println(i);
//			list.add(15);
//		}

		Class2 t = new Class3();

//		Bikes.chckAvailability();
//
//		t.chckAvailability("s");
//		t.method1(10);
	}

	public static void check(Tower t, int h) {
		if (t.tooHogh(h, 100)) {
			System.out.println("Yes");
		} else
			System.out.println("No");

	}

	public Class3() {

		System.out.println("Inside class 3");
		this.method1();

	}

	{
		System.out.println("Inside class 3 : block");
	}

//	static void method1(int i) {
//		System.out.println("method1 class3");
//	}

	void method1() {
		System.out.println("method1 class3");
	}

	@Override
	public void changeCadence(int newValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeGear(int newValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyBreaks(int decrement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isMoreEfficient(Bikes other) {
		// TODO Auto-generated method stub

	}

//	final method in superclass
//	void method1(int i) {
//		System.out.println("class 1 method1: int");
//	}
}
