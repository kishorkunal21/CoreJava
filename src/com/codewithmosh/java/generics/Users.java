package com.codewithmosh.java.generics;

public class Users implements Comparable<Users>{

	private String name, email;
	private int point;

	public Users(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public Users(int point) {
		this.point = point;
	}

	@Override
	public int compareTo(Users other) {
		return this.point-other.point;
	}
	
	@Override
	public String toString() {
		return "Point is "+this.point;
	}

}
