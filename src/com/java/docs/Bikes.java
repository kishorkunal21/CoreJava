package com.java.docs;

public interface Bikes extends Bikes2 {

	boolean available = true;

	void changeCadence(int newValue);

	void changeGear(int newValue);

	void speedUp(int increment);

	void applyBreaks(int decrement);

	void isMoreEfficient(Bikes other);

	static boolean chckAvailability() {
		return available;
	}

	default boolean chckAvailability(String s) {
		System.out.println("bikes ");
		return available;
	}

}
