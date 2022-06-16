package com.codewithmosh.java;

public abstract class AbstractTaxCalculator implements ITaxCalculator{
	
	protected float taxableIncome(float income,float expences) {
		return income-expences;
	}
	
}
