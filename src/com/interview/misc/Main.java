package com.interview.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.interview.misc.comparablecomparator.Laptops;
import com.interview.misc.comparablecomparator.LaptopsComparator;

public class Main {
	public static void main(String[] args) {
		MultiThreadingForkJoinFibonacci mt = new MultiThreadingForkJoinFibonacci(5);
		System.out.println(mt.compute());
		
		// comparable and comparator

		// Comparable : use comparable for own objects/entities
		List<Laptops> laptops = new ArrayList<Laptops>();

		laptops.add(new Laptops(6, 40000, "Asus"));
		laptops.add(new Laptops(8, 150000, "Apple"));
		laptops.add(new Laptops(12, 50000, "Dell"));

		Collections.sort(laptops);

		Iterator<Laptops> i = laptops.iterator();

		while (i.hasNext()) {
			Laptops l = i.next();
			System.out.println(l);
		}

		// Comparator : use comparable when you have binary

		Comparator<LaptopsComparator> lc = new Comparator<LaptopsComparator>() {

			@Override
			public int compare(LaptopsComparator arg0, LaptopsComparator arg1) {
				if (arg0.getPrice() > arg1.getPrice())
					return -1;
				else if (arg0.getPrice() < arg1.getPrice())
					return 1;
				return 0;
			}
		};

		List<LaptopsComparator> laps = new ArrayList<LaptopsComparator>();

		laps.add(new LaptopsComparator(6, 40000, "Asus"));
		laps.add(new LaptopsComparator(8, 150000, "Apple"));
		laps.add(new LaptopsComparator(12, 50000, "Dell"));

		Collections.sort(laps, lc);

		Iterator<LaptopsComparator> il = laps.iterator();

		System.out.println("\nUsing comparator to sort by Price Desc");
		while (il.hasNext()) {
			// LaptopsComparator element = il.next();
			System.out.println(il.next());
		}

	}

}
