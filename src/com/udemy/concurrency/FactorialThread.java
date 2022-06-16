package com.udemy.concurrency;

import java.math.BigInteger;

public class FactorialThread extends Thread {

	private long inputNumber;
	private BigInteger result;
	private boolean isFinished=false;
	
	public FactorialThread(long inputNumber) {
		this.inputNumber=inputNumber;
	}
	
	
	@Override
	public void run() {
		this.result=factorial(inputNumber);
		this.isFinished=true;
	}
	
	public BigInteger factorial(long n) {
		
		BigInteger tempResult = BigInteger.ONE;
		for(long i=n;i>0;i--) {
			tempResult=tempResult.multiply(new BigInteger(Long.toString(n)));
		}
		return tempResult;
		
	}
	
	public BigInteger getResult() {
		return this.result;
	}
	
	public long inputNumber() {
		return this.inputNumber;
	}
	
	public boolean IsFinished() {
		return this.isFinished;
	}
	
}
