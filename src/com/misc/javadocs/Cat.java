package com.misc.javadocs;

public class Cat extends Animal {
	public static void testClassMethod() {
		System.out.println("The static method in Cat");
	}

	public void testInstanceMethod() {
		System.out.println("The instance method in Cat");
	}

	public static void main(String[] args) {
		Cat myCat = new Cat();
		Animal myAnimal = new Cat2();
		Cat2 c2 = new Cat2();
		try {
			c2.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Animal.testClassMethod();
		myAnimal.testInstanceMethod();
	}
}
