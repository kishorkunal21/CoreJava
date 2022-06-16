package com.misc.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyText {
	static Map<Integer, String> dict = new HashMap<Integer, String>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		loadDict();
		System.out.println(converText(s.nextInt()));
	}

	static void loadDict() {
		dict = new HashMap<Integer, String>();
		dict.put(1, "ONE");
		dict.put(2, "TWO");
		dict.put(3, "THREE");
		dict.put(4, "FOUR");
		dict.put(5, "FIVE");
		dict.put(6, "SIX");
		dict.put(7, "SEVEN");
		dict.put(8, "EIGHT");
		dict.put(9, "NINE");
		dict.put(10, "TEN");
		dict.put(11, "ELEVEN");
		dict.put(12, "TWELVE");
		dict.put(13, "THIRTEEN");
		dict.put(14, "FOURTEEN");
		dict.put(15, "FIFTEEN");
		dict.put(16, "SIXTEEN");
		dict.put(17, "SEVENTEEN");
		dict.put(18, "EIGHTEEN");
		dict.put(19, "NINTEEN");
		dict.put(20, "TWENTY");
		dict.put(30, "THIRTY");
		dict.put(40, "FOURTY");
		dict.put(50, "FIFTY");
		dict.put(60, "SIXTY");
		dict.put(70, "SEVENTY");
		dict.put(80, "EIGHTY");
		dict.put(90, "NINTY");
		dict.put(100, "HUNDRED");
		dict.put(1000, "THOUSAND");
		dict.put(100000, "LAC");
	}

	static StringBuilder output = new StringBuilder();
	static String space = " ";
	static int factor = 1;

	static String converText(int n) {
		int length = Integer.toString(n).length();
		factor = (int) Math.pow(10, length - 1);

		if (length == 5)
			factor = 1000;
		if (length >= 7)
			factor = 100000;

		if (n < 20) {
			output.append(dict.get(n)).append(space);
			return output.toString().replace("null", space);
		}

		else {
			if (length == 2)
				output.append(dict.get((n / factor) * factor)).append(space);
			else {
				if (Integer.toString(n / factor).length() >= 2)
					output.append(convertSubText(n / factor)).append(space).append(dict.get(factor)).append(space);
				else
					output.append(dict.get((n / factor))).append(space).append(dict.get(factor)).append(space);

			}
			n = n % factor;
			if (factor / 10 > 0)
				factor = factor / 10;
			converText(n);

			return output.toString().replace("null", space);
		}
	}

	static String convertSubText(int n) {
		return dict.get((n / 10) * 10).concat(space).concat(dict.get((n % 10)));
	}

}
