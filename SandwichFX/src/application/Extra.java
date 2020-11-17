/**
 * This class handles the extra toppings added to a sandwich.
 * @author Joseph Hawkins, Gustavo Garcia
 */
package application;

public class Extra {
	
	private String name;
	
	/**
	 * Constructor for the extra class
	 * @param name of the extra
	 */
	public Extra(String name) {
		this.name = name;
	}
	
	/**
	 * Getter method for name
	 * @return the String "name"
	 */
	public String getName() {
		return this.name;
	}
	
	
}