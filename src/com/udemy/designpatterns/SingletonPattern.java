package com.udemy.designpatterns;

public class SingletonPattern {

	private SingletonPattern() {

	}

	private static final SingletonPattern INSTANCE = new SingletonPattern();

	public SingletonPattern getInstance() {
		return INSTANCE;
	}

}