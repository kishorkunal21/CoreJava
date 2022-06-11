package com.ocp.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Writer3 {
	
	public static void main(String[] args) {
		byte[] in =new byte[50];
		int size =0;
		
		FileOutputStream fo=null;
		FileInputStream fi =null;
		
		try {
			File f1 = new File("d://TestFile.txt");
			f1.createNewFile();
			
			fo = new FileOutputStream(f1);
			fo.write("kunal".getBytes());
			fo.flush();
			fo.close();
			
			fi = new FileInputStream("d://TestFile.txt");
			fi.read(in);
			for(byte c :in)
			{
				System.out.println((char)c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
