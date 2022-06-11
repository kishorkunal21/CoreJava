package com.docs.java;

public class Class1 {

	{
		System.out.println("Inside class 1 : block");
	}

	public Class1() {
		System.out.println("Inside class 1");
	}

	final void method1(int i) {
		System.out.println("class 1 method1: int");
	}

	static void method1(Integer i) {
		System.out.println("class 1 method1 : Integer");
	}

}
