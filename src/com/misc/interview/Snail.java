package com.misc.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Snail {
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line = in.readLine();
		String[] lines = line.split(" ");

		int n = Integer.parseInt(lines[0]);
		int m = Integer.parseInt(lines[1]);
		int h = Integer.parseInt(lines[2]);
		int max_no_fall = h - n;
		int avg = n - m;
		System.out.println(h / avg);
		if (h / n == 0) {
			System.out.println(h / avg);
		} else if (h % avg == 0) {
			System.out.println(h % avg);
			System.out.println(h / avg);
		} else {
			int to_cover_max_no_fall = max_no_fall / avg;
			int total = to_cover_max_no_fall + 1;
			System.out.println(total);
		}

	}

	// static int calculate(int n,int m,int h) {
	static int calculate() {
		int days = 0;

		int n = 3;
		int m = 2;
		int h = 11;

		// 3 - 2 = 1
		// 1+3 -2 = 2
		// 2+3 -2 = 3

		int max_no_fall = h - n;
		int to_cover_max_no_fall = max_no_fall / (n - m);
		int total = to_cover_max_no_fall + n;

		return days;

	}

}
