package com.java.docs;

public class Square2 extends Square implements Cloneable{
	int x ;
	public Square2(int x) {
		super(x);
		this.x = x;
	}

	public static void testStatic() {
		System.out.println("Square2: testStatic");
	}
	public void testInstance() {
		System.out.println("Square2: testInstance");
	}
	
	public int getArea() {
		return x^x;
	}

	@Override
	public int isLargerThan(Relatable other) {
		Square2 r  = (Square2)other;
		if(this.getArea()>=r.getArea())
			return 1;
		else 
			return 0;
	}

	@Override
	public String toString() {
		return "Square [x=" + x + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Square2) {
			Square2 s2 = (Square2)obj;
			return (this.getArea()==s2.getArea());
		}
		else 
			return false;
		
	}

	/*
	 * @Override public int hashCode() { return 1; }
	 */
	@Override
	 public Object clone()throws CloneNotSupportedException{  
			return (Square2)super.clone();  
		   }

}
