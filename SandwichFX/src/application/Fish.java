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
	 * Constructor for Beef sandwich
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
		return ingredients;
	}
	
	/**
	 * Adds an extra to the sandwich
	 * @return returns true if successful
	 */
	@Override
	public boolean add(Object obj) {
		if (obj instanceof Extra) {
			Extra item =  (Extra) obj;
			extras.add(item);
			return true;
		}
		return false;
	}
	
	/**
	 * Removes an extra from the sandwich
	 * @return returns true if successful
	 */
	@Override
	public boolean remove(Object obj) {
		if (obj instanceof Extra) {
			Extra item = (Extra) obj;
			for (int i = 0; i < extras.size(); i++) {
				String extra_name = extras.get(i).getName();
				if (extra_name.equals(item.getName())) {
					extras.remove(i);
					return true;
				}
			}
		}
		return false;
	}
}