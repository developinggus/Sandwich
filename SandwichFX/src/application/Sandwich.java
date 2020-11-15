/**
 * This class handles the abstract sandwich type which extends to different specific sandwiches.
 * @author Joseph Hawkins, Gustavo Garcia
 */
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
	
	/**
	 * Adds an extra to the sandwich
	 * @return returns true if successful
	 */
	@Override
	public boolean add(Object obj) {
		if (obj instanceof Extra) {
			if (extras.size() == MAX_EXTRAS) {
				return false;
			}
			Extra item =  (Extra) obj;
			for (int i = 0; i < extras.size(); i++) { //Checks if the extra exists
				if (extras.get(i).getName().equals(item.getName())) {
					return false;
				}
			}
			extras.add(item);
			return true;
		}
		return false;
	}
	
	/**
	 * Removes an extra from the sandwich
	 * @return returns true if successful, false otherwise.
	 */
	@Override
	public boolean remove(Object obj) {
		if (obj instanceof Extra) {
			Extra item = (Extra) obj;
			for (int i = 0; i < extras.size(); i++) {
				if (extras.get(i).getName().equals(item.getName())) {
					extras.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
}