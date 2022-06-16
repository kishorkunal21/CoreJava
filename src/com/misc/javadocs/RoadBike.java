package com.misc.javadocs;

public class RoadBike implements Bikes{
	
	private int cadance;
	private int speed;
	private int gear;

	public RoadBike(int cadance,int speed, int gear) {
		this.speed=speed;
		this.cadance=cadance;
		this.gear= gear;
	}

	@Override
	public void changeCadence(int newValue) {
		cadance = newValue;
	}

	@Override
	public void changeGear(int newValue) {
		gear = newValue;
		
	}

	@Override
	public void speedUp(int increment) {
		speed = speed+ increment;
		
	}

	@Override
	public void applyBreaks(int decrement) {
		speed = speed- decrement;
		
	}
	

	public int getCadance() {
		return cadance;
	}

	public int getSpeed() {
		return speed;
	}

	public int getGear() {
		return gear;
	}

	@Override
	public String toString() {
		return "RoadBike [cadance=" + cadance + ", speed=" + speed + ", gear=" + gear + "]";
	}

	@Override
	public void isMoreEfficient(Bikes other) {
		// TODO Auto-generated method stub
		
	}

}
