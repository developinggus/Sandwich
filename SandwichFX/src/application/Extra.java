/**
 * This class handles the extra toppings added to a sandwich.
 * @author Joseph Hawkins, Gustavo Garcia
 */
package application;

public class Extra {

	private String name;

	/**
	 * constructor for extra toppings.
	 * @param name string of the extra toppings name.
	 */
	public Extra(String name) {
		this.name = name;
	}

	/**
	 * Getter method for the toppings name.
	 * @return string of the extra toppings name.
	 */
	public String getName() {
		return this.name;
	}


}
