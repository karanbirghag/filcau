package ro.pava.filcau.domain;

public enum CardValue {

	TWO(2, 0), THREE(3, 0), FOUR(4, 0), TEN(10, 1), ELEVEN(11, 1);

	/** The number a card represents. */
	private int value;

	/** The number of points a card values. */
	private int points;


	private CardValue(final int val, final int pnts) {
		this.value = val;
		this.points = pnts;
	}


	public int getPoints() {
		return this.points;
	}


	public String toString() {
		return "" + this.value;
	}
}
