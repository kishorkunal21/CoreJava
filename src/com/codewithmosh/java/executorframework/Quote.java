package com.codewithmosh.java.executorframework;

public class Quote {
	
	private String site;
	private int price;
	public Quote(String site,int price) {
		this.site=site;
		this.price=price;		
	}
	public String getSite() {
		return site;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Quote [site=" + site + ", price=" + price + "]";
	}

}
