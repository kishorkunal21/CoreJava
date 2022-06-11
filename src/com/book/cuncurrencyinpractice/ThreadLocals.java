package com.book.cuncurrencyinpractice;


public class ThreadLocals extends ThreadLocal<Integer> {

	private final int factor = 5;

	@Override
	protected Integer initialValue() {
		// TODO Auto-generated method stub
		return factor;
	}

	@Override
	public void set(Integer value) {
		super.set(factor);
	}

}
