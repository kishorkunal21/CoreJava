package com.interview.misc;

public class Main2 {
	public static void main(String[] args) {

		Main2 m = new Main2();
		m.abc("jj");
	}

	void abc(String s) {
		System.out.println("String");
	}

	void abc(Object s) {
		System.out.println("Object");
	}
}
