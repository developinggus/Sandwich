/**
 * JUNIT test for Order.java
 * @author Joseph Hawkins and Gustavo Garcia
 */
package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class OrderTest {

	/*
	 * Tests the add method inside Order.java
	 */
	@Test
	void testAdd() {
		Order order = new Order();

		Beef krabby_patty = new Beef();
		krabby_patty.add("bacon");
		OrderLine orderline = new OrderLine(1,krabby_patty,krabby_patty.price());

		assertTrue(order.add(orderline));

		Fish super_patty = new Fish();
		super_patty.add("lettuce");
		OrderLine orderline2 = new OrderLine(2,super_patty,super_patty.price());

		assertTrue(order.add(orderline2));

		//

	}

	/*
	 * Tests the remove method inside Order.java
	 */
	@Test
	void testRemove() {

		//removing from an empty list
		//removing from end
		//removing from beginning
		//removing from middle


		Order order = new Order();

		Beef krabby_patty = new Beef();
		krabby_patty.add("bacon");
		OrderLine orderline = new OrderLine(1,krabby_patty,krabby_patty.price());
		assertFalse(order.remove(orderline));
		order.add(orderline);

		Fish super_patty = new Fish();
		super_patty.add("lettuce");
		OrderLine orderline2 = new OrderLine(2,super_patty,super_patty.price());
		order.add(orderline2);

		Chicken mega_patty = new Chicken();
		mega_patty.add("tomato");
		OrderLine orderline3 = new OrderLine(3,mega_patty,mega_patty.price());
		order.add(orderline3);

		assertTrue(order.remove(orderline3));
		assertTrue(order.remove(orderline));
		assertTrue(order.remove(orderline2));



	}

	/*
	 * Tests the getOrders method inside Order.java
	 */
	@Test
	void testGetOrders() {
		Order order = new Order();

		Beef krabby_patty = new Beef();
		krabby_patty.add("bacon");
		OrderLine orderline = new OrderLine(1,krabby_patty,krabby_patty.price());
		order.add(orderline);

		Fish super_patty = new Fish();
		super_patty.add("lettuce");
		OrderLine orderline2 = new OrderLine(2,super_patty,super_patty.price());
		order.add(orderline2);

		Chicken mega_patty = new Chicken();
		mega_patty.add("tomato");
		OrderLine orderline3 = new OrderLine(3,mega_patty,mega_patty.price());
		order.add(orderline3);

		Order order1 = new Order();
		order1.add(orderline);
		order1.add(orderline2);
		order1.add(orderline3);


		assertTrue(compareLines(order1.getOrders(),order.getOrders()));

		order1.remove(orderline);
		assertFalse(compareLines(order1.getOrders(),order.getOrders()));

	}

	/**
	 * compare two arraylists of orderlines.
	 * @param a array list of orderlines
	 * @param b array list of orderlines
	 * @return true if the lists are identical, false otherwise.
	 */
	boolean compareLines(ArrayList<OrderLine> a, ArrayList<OrderLine> b) {

		if ( a.size() != b.size() ) {
			return false;
		}

		for ( int i = 0; i < a.size(); i++) {
			if ( !(a.get(i).toString()) .equals ( (b.get(i).toString() ) ) ) {
				return false;
			}
		}
		return true;
	}

}
