package com.interview.misc;

public interface MisReports {

	String getReport();

	default int calculate(int x, int y) {
		return x * y;
	}

}
