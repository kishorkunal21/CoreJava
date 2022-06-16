package com.misc.interview.comparablecomparator;

public class Laptops implements Comparable<Laptops> {

	private String name;
	private int ram;
	private float price;

	public Laptops(int ram, float price, String string) {
		super();
		this.ram = ram;
		this.price = price;
		this.name = string;
	}

	@Override
	public int compareTo(Laptops o) {
		if (this.ram > o.ram)
			return 1;
		else if (this.ram < o.ram)
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Laptops [name=" + name + ", ram=" + ram + ", price=" + price + "]";
	}

}
