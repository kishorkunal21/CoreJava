package com.java.docs;

public class Cat2 extends Animal implements Cloneable {
	public static void testClassMethod() {
		System.out.println("The static method in Cat2");
	}

	public void testInstanceMethod() {
		System.out.println("The instance method in Cat2");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
