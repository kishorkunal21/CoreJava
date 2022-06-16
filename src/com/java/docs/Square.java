package com.java.docs;

public class Square implements Relatable{
	int x ;
	public Square(int x) {
		this.x = x;
	}
	
	public int getArea() {
		return x^x;
	}

	@Override
	public int isLargerThan(Relatable other) {
		Square r  = (Square)other;
		if(this.getArea()>=r.getArea())
			return 1;
		else 
			return 0;
	}

	@Override
	public String toString() {
		return "Square [x=" + x + "]";
	}
	
	public static void testStatic() {
		System.out.println("Square2: testStatic");
	}
	public void testInstance() {
		System.out.println("Square2: testInstance");
	}

}
