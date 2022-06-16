package com.misc.javadocs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		char [] input = {'a','b','c','d'};
		MyString s = new MyString(input);
		System.out.println(s);
		s = new MyString(input);
		System.out.println(s);
		
	}
	
	void inheritance_compare() {
		RoadBike rb2 = new RoadBike(100, 32, 7);
		MountainBike mb = new MountainBike(10, 30, 18);
		MountainBike mb2 = new MountainBike(110, 31, 5);
		MountainBike mb3 = new MountainBike(120, 32, 10);
		MountainBike mb4 = new MountainBike(101, 33, 9);
		List<MountainBike> list  = new ArrayList<MountainBike>();
		Collections.addAll(list, mb,mb2,mb3,mb4);
		//Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, new MountainBike());
		System.out.println(list);
	}
	static void comparator() {

		Rectangle r = new Rectangle(15,20,new Point(5, 10));
		Square r1 = new Square(12);
		Rectangle r2 = new Rectangle(15,20,new Point(5, 10));
		System.out.println(r.isLargerThan(r2));
		
		System.out.println(r.findLargest(r, r2));
		
		Square2 s = new Square2(5);
		Square2 s2 = new Square2(5);
		try {
			Square2 s3 = (Square2)s.clone();
			System.out.println(s3.x);
			System.out.println("Compare hascodes clone : "+s3.hashCode()+ " " + s.hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(s.equals(s2));
		System.out.println(s.getClass().getSimpleName());
		
		
		
	
	}
	static void inheritance() {
		setSpeed(new MountainBike(100, 30, 7));
	}

	static void setSpeed(Bikes bike) {
		System.out.println(bike);
	}
	
	static void arrays() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 33, 44, 55 , 11, 22 };
		int[] combine=new int[10];
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.arraycopy(arr1,0,combine,0,5);
		System.arraycopy(arr2,0,combine,5,5);
		System.out.println(Arrays.toString(combine));
		System.out.println(Arrays.binarySearch(combine, 55));
		System.out.println(Arrays.equals(arr1, arr2));
		Arrays.parallelSort(combine);
		System.out.println(Arrays.toString(combine));
		//multidimetional array
		String[][] names = { { "Mr.", "Mrs.", "Ms." }, { "Smith", "Jones" } };

		System.out.println(names[0][0] + "" + names[1][0]);
		System.out.println(names[0][2] + "" + names[1][1]);
	}

}
