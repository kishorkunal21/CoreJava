package com.codewithmosh.java;

public class TaxReport {
	private TaxCalculator2018 calculator;
	
	public TaxReport() {
		calculator = new TaxCalculator2018(100000);
	}
	public void show() {
		double tax = calculator.calculateTax();
		System.out.println("Tax:"+tax);
	}
	
	

}
