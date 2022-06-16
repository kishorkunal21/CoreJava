package com.mosh.java;

public class TaxReport3 extends AbstractTaxCalculator {
	private TaxCalculator2018 calculator;
	
	public TaxReport3() {
		calculator = new TaxCalculator2018(100000);
	}
	public void show() {
		double tax = calculator.calculateTax();
		System.out.println("Tax:"+tax);
	}
	@Override
	public double calculateTax() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
