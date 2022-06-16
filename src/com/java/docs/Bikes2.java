package com.java.docs;

public interface Bikes2 {

	default boolean chckAvailability(String s) {
		System.out.println("bikes 2");
		return true;
	}
}
