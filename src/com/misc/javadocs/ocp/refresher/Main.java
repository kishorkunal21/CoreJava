package com.misc.javadocs.ocp.refresher;

public class Main {

	// enum CoffeeSizeEnum{REGULARS};
	public static void main(String[] args) {
		String str = "Kunal fail pass";
		System.out.println(str.contains("pas"));
		// System.out.println("Coffee "+CoffeeSizeEnum.getValue());
		System.out.println("Coffee " + CoffeeSizeEnum.valueOf("REGULAR"));

	}

}
