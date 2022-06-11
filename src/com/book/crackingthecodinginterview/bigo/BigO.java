package com.book.crackingthecodinginterview.bigo;

public class BigO {

	public int recursiveSum(int n) {

		if (n <= 0) {
			return 0;
		} else {
			System.out.println(n);
			return n + recursiveSum(n - 1);
		}

	}

}
