package com.misc.interview.comparablecomparator;

public class LaptopsComparator {

	private String name;
	private int ram;
	private float price;

	public LaptopsComparator(int ram, float price, String string) {
		super();
		this.ram = ram;
		this.price = price;
		this.name = string;
	}

	public String getName() {
		return name;
	}

	public int getRam() {
		return ram;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Laptops [name=" + name + ", ram=" + ram + ", price=" + price + "]";
	}

}
