package application;

public class OrderLine {
	private int lineNumber;
	private Sandwich sandwich;
	private double price;
	
	public OrderLine(int lineNumber, Sandwich sandwich, double price) {
		this.lineNumber = lineNumber;
		this.sandwich = sandwich;
		this.price = price;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
}