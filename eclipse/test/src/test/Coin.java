package test;

public enum Coin {
	PENNY(1, true), NICKEL(5, false), DIME(10), QUARTER(25);
	
	private final int value;
	private final boolean isCopperColored;
	
	Coin(int value) {
		this(value, false);
	}
	
	Coin(int value, boolean isCopperColored) {
		this.value = value;
		this.isCopperColored = isCopperColored;
	}
	
	
}

