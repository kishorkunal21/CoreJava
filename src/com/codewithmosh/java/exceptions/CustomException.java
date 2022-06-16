package com.codewithmosh.java.exceptions;
//checked -  extend Exception
//unchecked -  extend RuntimeException
public class CustomException extends Exception {
	public CustomException() {
		super("Insufficient funds exception");
	}
	public CustomException(String message) {
		super(message);
	}

}
