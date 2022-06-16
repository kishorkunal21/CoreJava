package com.misc.javadocs.ocp.refresher;

public enum CoffeeSizeEnum {
	TALL(1),REGULAR(2),SHORT(2);
	/*SIGN_CREATE(0),
    SIGN_CREATE_BONUS(1),
    HOME_SCREEN(2),
    REGISTER_SCREEN(3);*/

    private final int value;

    CoffeeSizeEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
	/*CoffeeSizeEnum(int ounce)
	{
		
	}
	private int ounce;
	public int getOunce()
	{
		return ounce;
	}*/
}

