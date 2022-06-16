package com.misc.interview;

import java.util.Arrays;
import java.util.Scanner;

public class Stairs {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(countways(s.nextInt()));

	}

	static int countways(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countways(n, memo);
	}

	static int countways(int n, int[] memo) {

		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else if (memo[n] > -1)
			return memo[n];
		else
			memo[n] = countways(n - 1, memo) + countways(n - 2, memo) + countways(n - 3, memo);
		return memo[n];
	}

}
