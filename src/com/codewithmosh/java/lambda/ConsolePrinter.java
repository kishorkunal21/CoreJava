package com.codewithmosh.java.lambda;

public class ConsolePrinter implements Printer{

	@Override
	public void print(String s) {
		System.out.println("Print : "+s);
	}

}
