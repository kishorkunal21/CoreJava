package com.ocp.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Writer2 {
	
	public static void main(String[] args) {
		char[] in =new char[50];
		int size =0;
		
		try {
			File f1 = new File("d://TestFile.txt");
			f1.createNewFile();
			
			FileWriter fw = new FileWriter(f1);
			fw.write("kk\nmotki\n");
			fw.flush();
			fw.close();
			
			FileReader fr = new FileReader("d://TestFile.txt");
			System.out.println(fr.ready());
			size=fr.read(in);
			System.out.println("size="+size);
			
			for(char c :in)
			{
				System.out.println(c);
			}
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
