package com.java.docs;

import java.util.Comparator;

public class MountainBike implements Bikes, Comparable<MountainBike>,Comparator<MountainBike> {

	private int cadance;
	private int speed;
	private int gear;

	public MountainBike(int cadance, int speed, int gear) {
		this.speed = speed;
		this.cadance = cadance;
		this.gear = gear;
	}

	public MountainBike() {

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
		speed = speed + increment;

	}

	@Override
	public void applyBreaks(int decrement) {
		speed = speed - decrement;

	}

	@Override
	public String toString() {
		return "MountainBike [cadance=" + cadance + ", speed=" + speed + ", gear=" + gear + "]";
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
	public void isMoreEfficient(Bikes other) {
		MountainBike mb = null;
		if (other instanceof MountainBike) {
			mb = (MountainBike) other;
			if (this.getGear() > mb.getGear())
				System.out.println("Efficient");
			else
				System.out.println("Not efficient");
		} else
			System.out.println("Not instance of Bike");

	}

	@Override
	public int compareTo(MountainBike other) {
		if (this.getSpeed() >= other.getSpeed())
			return 1;
		else
			return -1;
	}

	@Override
	public int compare(MountainBike arg0, MountainBike arg1) {
		return arg0.getGear() - arg1.getGear();
	}

}
