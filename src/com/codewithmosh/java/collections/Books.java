package com.codewithmosh.java.collections;

public class Books implements Comparable<Books> {
	
	private String name;
	private String author;
	
	public Books(String name,String author) {
		this.name=name;
		this.author=author;
	}
	

	public String getAuthor() {
		return author;
	}


	@Override
	public int compareTo(Books other) {
		
		return name.compareTo(other.name);
	}
	@Override
	public String toString() {
		return this.name;
	}
}
