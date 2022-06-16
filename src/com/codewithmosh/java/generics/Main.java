package com.codewithmosh.java.generics;

public class Main {

	public static void main(String[] args) {
		// TYPE can be Referance type only - NO PREMITIVE TYPE
		GenericList<Integer> list = new GenericList<Integer>();
		list.add(10);// Java wraps this int to Integer class[BOXING]
		list.add(20);
		list.add(30);
		int get = list.get(0);//// UNBOXING
		System.out.println(list.get(0));
		
		//check comparable interface
		Users u1  = new Users(10);
		Users u2  = new Users(20);
		
		System.out.println(u1.compareTo(u2));
		
		//Generic method inside non generic class
		Utils u = new Utils();
		System.out.println(u.max(10,20));
		u.print(10, "OMI");
		
		//check interfacing in Generic | USING WILDCARDS
		Users u3 = new Intructor(10);
		u.printUser(u3);
		
		GenericList<Intructor> usersList1 = new GenericList<Intructor>();
		GenericList<Users> usersList = new GenericList<Users>();
		usersList.add(u1);
		u.printUser(usersList);
		
		

	}

}
