/**
 * This class handles the fish sandwich for our order platform.
 * @author Joseph Hawkins, Gustavo Garcia
 */

package application;

public class Fish extends Sandwich {
	
	private String ingredients = 
			"Grilled Snapper,"
			+ "Cilantro,"
			+ "Lime";
	
	/**
	 * Constructor for Fish sandwich
	 */
	public Fish() {
		
	}
	/**
 	* Calculates the price of the sandwich.
 	* @return The price of the sandwich
 	*/
	@Override
	public double price(){
		return 12.99 + (extras.size() * PER_EXTRA);
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
		return "Fish Sandwich: " + ingredients + "," + String.format("%,.2f", price());
	}
}