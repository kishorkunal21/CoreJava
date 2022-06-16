package com.misc.javadocs.ocp.io;
import java.io.File;

public class TestIO {

	public static void main(String[] args) {
		try {
			File f1 =new File("d://TestFile.txt");
			System.out.println(f1.exists());
			System.out.println(f1.createNewFile());
			System.out.println(f1.exists());
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
