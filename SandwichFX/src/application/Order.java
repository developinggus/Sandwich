package application;

import java.util.ArrayList;

public class Order implements Customizable {
	public static int lineNumber;
	private ArrayList<OrderLine> orderlines;
	
	@Override
	public boolean add(Object obj) {
		return true;
	}
	
	@Override
	public boolean remove(Object obj) {
		return true;
	}
}