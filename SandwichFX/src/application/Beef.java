/**
 * This class handles the beef sandwich for our order platform.
 * @author Joseph Hawkins, Gustavo Garcia
 */
package application;

public class Beef extends Sandwich {
	
	private String ingredients = 
			"Roast Beef,"
			+ "Provolone Cheese,"
			+ "Mustard";
	
	/**
	 * Constructor for Beef sandwich
	 */
	public Beef() {
		
	}
	/**
 	* Calculates the price of the sandwich.
 	* @return The price of the sandwich
 	*/
	@Override
	public double price(){
		return 10.99 + (extras.size() * PER_EXTRA);
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
		return "Beef Sandwich:" + ingredients + "," + String.format("%,.2f", price());
	}
}