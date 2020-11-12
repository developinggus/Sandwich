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
		if (obj instanceof OrderLine) {
			OrderLine item = (OrderLine) obj;
			for (int i = 0; i < orderlines.size(); i++) {
				if (item.getLineNumber() == orderlines.get(i).getLineNumber()) {
					//orderlines.remove(i);
					//int removed_order_index = i;
					//for (int j = i; j < orderlines.size(); j++) {
						
					//}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		lineNumber = 5;
		Beef beef_patty = new Beef();
		Extra bacon = new Extra("bacon");
		beef_patty.add(bacon);
		OrderLine order = new OrderLine(lineNumber,beef_patty,beef_patty.price()); 
		Order wait_line = new Order();
		lineNumber = 20;
		System.out.print(order.getLineNumber());
		wait_line.add(order);
	}
}