/**
 * This class defines the orderLine object. It consists of a lineNumber, sandwich,
 * price, and getter and setter methods
 * @author Joeseph Hawkins, Gustavo Garcia
 */
package application;

public class OrderLine {
	private int lineNumber;
	private Sandwich sandwich;
	private double price;
	
	/**
	 * Constructor for the orderLine obejct
	 * @param lineNumber is the serial number of the order
	 * @param sandwich is the sandwich object
	 * @param price is the price of the order
	 */
	public OrderLine(int lineNumber, Sandwich sandwich, double price) {
		this.lineNumber = lineNumber;
		this.sandwich = sandwich;
		this.price = price;
	}
	
	/**
	 * Getter method for the lineNumber
	 * @return the lineNumber for the orderLine
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	
	/**
	 * To string method for the contents of an orderline.
	 * @return the string format of an order
	 */
	@Override
	public String toString() {
		return Integer.toString(lineNumber) + " " 
				+ sandwich.toString();	
	}
	/**
	 * Setter method for lineNumber
	 * @param n is the new lineNumber
	 */
	public void setLineNumber(int n) {
		this.lineNumber = n;
	}
}