package application;

public class Beef extends Sandwich {
	
	private String ingredients = 
			"Roast Beef,"
			+ "Spicy Sauce,"
			+ "Pickles";
	
	@Override
	public double price(){
		return 10.99 + (extras.size() * PER_EXTRA);
	}
	
	@Override
	public String toString() {
		for (int i = 0; i < extras.size(); i++) {
				ingredients = ingredients + "," + extras.get(i).getName();
		}
		return ingredients;
	}
	
	@Override
	public boolean add(Object obj) {
		if (obj instanceof Extra) {
			Extra item =  (Extra) obj;
			extras.add(item);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean remove(Object obj) {
		return false;
	}
}