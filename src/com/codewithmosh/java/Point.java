package com.codewithmosh.java;

public class Point {
	
	private int x,y=0;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public boolean equals(Object obj) {
		Point other =(Point)obj;
		return other.x==x && other.y==y;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	

}
