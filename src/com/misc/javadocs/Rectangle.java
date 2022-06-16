package com.misc.javadocs;

public class Rectangle implements Relatable{

	private int width;
	private int height;
	private Point origin;

	public Rectangle(int width, int height, Point origin) {
		this.width = width;
		this.height = height;
		this.origin = origin;
	}

	public Rectangle() {
		origin = new Point(0, 0);
	}
	
	public void move(int width, int height) {
		origin.x=width;
		origin.y=height;
	}
	
	public int getArea() {
		return width*height;
	}

	@Override
	public int isLargerThan(Relatable other) {
		Rectangle r  = (Rectangle)other;
		if(this.getArea()>=r.getArea())
			return 1;
		else 
			return 0;
	}
	
	public Object findLargest(Object object1,Object object2) {
		Relatable r1 = (Relatable)object1;
		Relatable r2 = (Relatable)object2;
		if(r1.isLargerThan(r2)>0) {
			return r1;
		}
		else 
			return r2;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", origin=" + origin + "]";
	}

}
