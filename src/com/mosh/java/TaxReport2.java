package com.mosh.java;
//constructor injection
public class TaxReport2 {
	private ITaxCalculator calculator;
	
	public TaxReport2(ITaxCalculator calculator) {
		this.calculator = calculator;
	}
	public void show() {
		double tax = calculator.calculateTax();
		System.out.println("Tax:"+tax);
	}
	//METHOD INJECTION
	public void show(ITaxCalculator calculator) {
		double tax = calculator.calculateTax();
		System.out.println("Tax:"+tax);
	}
	
	//setter injection
	public void setCalculator(ITaxCalculator calculator) {
		this.calculator = calculator;
	}

}
