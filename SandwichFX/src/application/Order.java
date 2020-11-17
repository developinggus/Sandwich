/**
 * This class handles the ArrayList of OrderLine's.
 * @author Joseph Hawkins, Gustavo Garcia
 */
package application;

import java.util.ArrayList;

public class Order implements Customizable {
	public static int lineNumber;
	private ArrayList<OrderLine> orderlines;

	/**
	 * Constructor for Order. Creates a new ArrayList.
	 */
	public Order() {
		this.orderlines = new ArrayList<OrderLine>();
		lineNumber = 1;
	}
	

	/**
	 * Override of the abstract add() class. This will add the orderLine object to the
	 * ArrayList
	 * @return True if it is inserted, False otherwise
	 */
	@Override
	public boolean add(Object obj) {
		if (obj instanceof OrderLine) {
			OrderLine item = (OrderLine) obj;
			orderlines.add(item);
			lineNumber ++;
			return true;
		}
		return false;
	}

	/**
	 * Override of the abstract remove() class. Will remove the orderLine object
	 * from the ArrayList and rearrange the LineNumbers so it stays in sequence.
	 * @return Returns True if it is removed, False otherwise
	 */
	@Override
	public boolean remove(Object obj) {
		//I think this is decrementing elements below the target but not above
		if (obj instanceof OrderLine) {
			OrderLine item = (OrderLine) obj;
			for (int i = 0; i < orderlines.size(); i++) {
				if (item.getLineNumber() == orderlines.get(i).getLineNumber()) {
					orderlines.remove(i);
					for (int j = 0; j < orderlines.size(); j++) {
						if (item.getLineNumber() < orderlines.get(j).getLineNumber()) {
							orderlines.get(j).setLineNumber
							((orderlines.get(j).getLineNumber()) - 1);
						}
					}
					lineNumber --;
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * Getter method for returning the orders.
	 * @return all sandwiches for this order.
	 */
	public ArrayList<OrderLine> getOrders(){
		return this.orderlines;
	}

	public static void main(String[] args) {
	}
}
