package com.codewithmosh.java.collections;

import java.util.Comparator;

public class AuthorComparator implements Comparator<Books> {

	@Override
	public int compare(Books o1, Books o2) {		
		return o1.getAuthor().compareTo(o2.getAuthor());
	}

}
