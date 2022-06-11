package com.docs.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import com.ocp.oo.GameShape;
import com.ocp.oo.TilePiece;

public class Main {

	public static void main(String[] args) {}

	static void objectStreams() {

		String fileName = "d:\\etc\\ObjectOutputStream.txt";
		TilePiece t1 = new TilePiece();
		t1.tileName="Tile 1";
		TilePiece t2 = new TilePiece();
		t2.tileName="Tile 2";
		System.out.println("T1 "+t1.tileName + " "+t1.getClass().getName());
		
		GameShape g1 = new GameShape();
		t2.gameName="Game 1";
		GameShape g2 = new GameShape();
		g2.gameName="Game 2";
		
		
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			out.writeObject(t1);
			out.writeObject(t1);
			out.writeObject(t2);
			out.writeObject(g1);
			out.writeObject(g2);
			out.close();
			out.flush();
			
			in  = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			TilePiece tt1 =(TilePiece) in.readObject();
			TilePiece tt2 =(TilePiece) in.readObject();
			
			System.out.println("T1 "+tt1.tileName + " "+tt1.getClass().getName());
			System.out.println("tt2 "+tt2.tileName + " "+tt2.getClass().getName());
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	
	}
	static void dataInputStreams() {

		double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
		int[] units = { 12, 8, 13, 29, 50 };
		String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };

		DataInputStream in = null;
		DataOutputStream out = null;

		String fileName = "d:\\etc\\DataOutputStream.txt";
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));

			for (int i = 0; i < prices.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
			System.out.println("Done");

			out.close();
			out.flush();
			// read from file
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			while (true) {
				int unit = in.readInt();
				double price = in.readDouble();
				String desc = in.readUTF();
				System.out.println("Price : " + price + " unit : " + unit + " desc:" + desc);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				out.flush();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	static void console() {

		Console console = System.console();
		if (console == null) {
			System.out.println("No console available");
			System.exit(1);
		}

		String login = "";

		try {
			login = console.readLine("Enter login : ");

			char[] password = console.readPassword("Enter Password");
			char[] confirmPassword = console.readPassword("Confirm Password");

			do {
				System.out.println("Password doesn't match");
				password = console.readPassword("Enter Password");
				confirmPassword = console.readPassword("Confirm Password");
			} while (Arrays.equals(password, confirmPassword));

			System.out.println("Logged in as " + login);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			console.flush();
		}

	}

	static void scanner() {

		Scanner scanner = null;

		try {
			scanner = new Scanner(new BufferedReader(new FileReader("d:\\etc\\test.txt")));

			while (scanner.hasNext()) {
				scanner.useDelimiter("\n");
				System.out.println(scanner.next());
			}
			// scan numbers use locale
			scanner = new Scanner(new BufferedReader(new FileReader("d:\\etc\\usnumbers.txt")));
			scanner.useLocale(Locale.US);
			double sum = 0;
			while (scanner.hasNext()) {
				if (scanner.hasNextDouble())
					sum += scanner.nextDouble();
				else
					scanner.next();
				System.out.println("Sum = " + sum);
			}

			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				scanner.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	static void bufferedReader() {

		BufferedReader in = null;
		BufferedWriter out = null;

		try {
			in = new BufferedReader(new FileReader("d:\\etc\\test.txt"));
			out = new BufferedWriter(new FileWriter("d:\\etc\\test_out_line_buffer.txt"));

			String s;
			while ((s = in.readLine()) != null) {
				out.write(s);
				out.newLine();
				System.out.println(s);
			}
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	static void characterStream_line_oriented_io() {

		BufferedReader in = null;
		PrintWriter out = null;

		try {
			in = new BufferedReader(new FileReader("d:\\etc\\test.txt"));
			out = new PrintWriter(new FileWriter("d:\\etc\\test_out_line.txt"));

			String s;
			while ((s = in.readLine()) != null) {
				out.println(s);
				System.out.println(s);
			}
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	static void characterStream() {

		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader("d:\\etc\\test.txt");
			out = new FileWriter("d:\\etc\\test_out_char.txt");

			int c;
			while ((c = in.read()) != -1) {
				System.out.println(c);
				out.write(c);
			}
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	static void byteStream() {

		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream("d:\\etc\\test.txt");
			out = new FileOutputStream("d:\\etc\\test_out.txt");

			int c;
			while ((c = in.read()) != -1) {
				System.out.println(c);
				out.write(c);
			}
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
