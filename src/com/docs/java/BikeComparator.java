package com.docs.java;

import java.util.Comparator;

public class BikeComparator implements Comparator<MountainBike> {

	@Override
	public int compare(MountainBike o1, MountainBike o2) {
		return o1.getGear() - o2.getGear();
	}

}
