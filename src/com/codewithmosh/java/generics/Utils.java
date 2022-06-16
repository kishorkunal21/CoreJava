package com.codewithmosh.java.generics;

public class Utils {
	
	public  <T extends Comparable<T>> T max(T first, T second)
	{
		return (first.compareTo(second)<0)?first:second;
	}
	
	public <K,V> void print (K key, V value) {
		System.out.println(key +" : "+ value);
	}
	
	public void printUser(Users user) {
		System.out.println(user);
	}
	//? =  WILDCARD 
	//CREATES ANANOMOUS CLASS CAPT#1 THAT EXTENDS USERS AND SUBCLASSES
	//EXTEND TO READ
	//SUPER TO ADD
	public void printUser(GenericList<? super Users> user) {
		System.out.println(user.get(0));
	}
}
