package com.interview.misc;

public class SingletonClass {
	private static volatile SingletonClass _instance; // volatile variable

	public static SingletonClass getInstance() {
		if (_instance == null) {
			synchronized (SingletonClass.class) {
				if (_instance == null)
					_instance = new SingletonClass();
			}
		}
		return _instance;
	}
}
