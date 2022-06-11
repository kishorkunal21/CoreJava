package com.interview.misc;

public final class Immutables {
	private final String input;

	private Immutables(String input) {

		this.input = input;
	}

	public String getId() {
		return this.input;
	}

	public static void main(String[] args) {

		/*
		 * String s = "KK"; String s1 = "KK"; System.out.println(s.hashCode() + "" +
		 * s1.hashCode());
		 * 
		 * int i = 10; int j = i; j = 11; System.out.println(i);
		 */
	}

}
