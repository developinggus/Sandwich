/**
 * This class handles the chicken sandwich for our order platform.
 * @author Joseph Hawkins, Gustavo Garcia
 */

package application;

public class Chicken extends Sandwich {
	
	private String ingredients = 
			"Fried Chicken,"
			+ "Spicy Sauce,"
			+ "Pickles";
	
	/**
	 * Constructor for Chicken sandwich
	 */
	public Chicken() {
		
	}
	/**
 	* Calculates the price of the sandwich.
 	* @return The price of the sandwich
 	*/
	@Override
	public double price(){
		return 8.99 + (extras.size() * PER_EXTRA);
	}
	
	/**
	 * Creates a string of the ingredients
	 * @return returns the string that was created
	 */ 
	@Override
	public String toString() {
		for (int i = 0; i < extras.size(); i++) {
				ingredients = ingredients + "," + extras.get(i).getName();
		}
		return "Chicken Sandwich: " + ingredients + "," + String.format("%,.2f", price());
	}
}