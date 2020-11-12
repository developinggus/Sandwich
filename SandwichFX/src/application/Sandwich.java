package application;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;
	
	/**
	 * Constructor for sandwich. Initializes the extras ArrayList.
	 */
	public Sandwich() {
		this.extras = new ArrayList<Extra>();
	}
	
	public abstract double price();
	
	@Override
	public String toString() {
		return "";
	}
	
}