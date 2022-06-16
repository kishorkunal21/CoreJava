package com.mosh.java.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExeptionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			customExceptionCheck();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	private static void customExceptionCheck() throws CustomException {
		if(4<5) throw new CustomException();
	}
	
	private static void show(){
		try (FileReader file = new FileReader("file.txt") ; 
				){
			int val = file.read();
			
			
			new SimpleDateFormat().parse("");
			System.out.println("File opened");
		} catch (IOException |ParseException   e) {
			e.printStackTrace();
		}
	}

}
