package com.udemy.designpatterns.factorypattern;

public class ProfessionFactory {

	public Profession get(String type) {

		if (type.equalsIgnoreCase("teacher"))
			return new Teacher();
		else if (type.equalsIgnoreCase("professor"))
			return new Professor();
		else
			return null;

	}

}
