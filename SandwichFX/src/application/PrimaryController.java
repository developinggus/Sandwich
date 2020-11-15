/**
 * This class is the main controller.
 * @author Joseph Hawkins, Gustavo Garcia
 */
package application;

import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {

	ObservableList<String> sandwiches = FXCollections
			.observableArrayList("Chicken", "Beef", "Fish");
	
	ObservableList<String> ingredients = FXCollections
			.observableArrayList();
	
	ObservableList<String> addOnToppings = FXCollections
			.observableArrayList();
	
	Sandwich sandwich;
   
	@FXML
    private ComboBox <String> sandwichType;
	
    @FXML
    private ListView <String> ingredientListView;
    
    @FXML
    private ListView<String> extraIngredients;

    @FXML
    private ListView<String> addedIngredients;
    
    @FXML
    private ImageView sandwichPic;
    
    @FXML
    private TextArea priceTextArea;
    
    /**
     * Set new picture and create object when a different sandwich is chosen on the combo box.
     * @param event a different sandwich is chosen on the combo box
     */
    @FXML
    void newSandwichSelected(ActionEvent event) {
    	String selection = sandwichType.getValue();
    	sandwich = null;
    	//change image to URI instead of URL in-case the picture is taken down.
    	if(selection.equals("Chicken")) {
    		sandwich = new Chicken();
    		Image im = new Image("https://cdn.cnn.com/cnnnext/dam/assets/200522115738-20200522-kfc-chicken-sandwich-super-tease.jpg");
    		sandwichPic.setImage(im);
    	}
    	
    	if(selection.equals("Fish")) {
    		sandwich = new Fish();
    		Image im = new Image("https://showmars.com/img/menu/FishSandwich-675x456.png");
    		sandwichPic.setImage(im);
    	}
    	
    	if(selection.equals("Beef")) {
    		sandwich = new Beef();
    		Image im = new Image("https://www.foxvalleyfoodie.com/wp-content/uploads/2018/01/arbys-roast-beef.jpg");
    		sandwichPic.setImage(im);

    	}
    	

    	String sandwichPrice = "$" + String.format("%,.2f", sandwich.price());
    	priceTextArea.setText(sandwichPrice);

    	clearIngredients();
    	//change ingredients included

    }
    
    /**
     * Adjusts the price of a sandwich based on the current toppings.
     */
    void adjustPrice() {
    	
    }
    
    
    /**
     * Add extra ingredients to the sandwich object and handle price change.
     * @param event pressing add button after selecting a topping.
     */
    @FXML
    void AddIngredients(ActionEvent event) {
    	if (!validExtraIngredient()) {
    		return;
    	}
    	String selected = extraIngredients.getSelectionModel().getSelectedItem();
    	if (selected != null) {
    		extraIngredients.getItems().remove(selected);
    		addedIngredients.getItems().add(selected);
    		Extra topping = new Extra(selected);
    		sandwich.add(topping);
        	String sandwichPrice = "$" + String.format("%,.2f", sandwich.price());
        	//String.valueOf((sandwich.price()))	
        	priceTextArea.setText(sandwichPrice);
    	}
    }

    
    /**
     * Remove extra ingredients from the sandwich.
     *
     */
    void clearIngredients() {
    	
    	if (addedIngredients.getItems().isEmpty()) {
    		return;
    	}
    	
    	String[] addedIngredients_array = (String.join(",", addedIngredients.getItems())).split(",");	//Converts listview to array
    	addedIngredients.getItems().clear();
    	for (int i = 0; i < addedIngredients_array.length; i++) {
    		extraIngredients.getItems().add(addedIngredients_array[i]);
    		Extra extra = new Extra(addedIngredients_array[i]);
    		sandwich.remove(extra);
    	}
    	    	
    	String sandwichPrice = "$" + String.format("%,.2f", sandwich.price());
    	priceTextArea.setText(sandwichPrice);
 
    }
      
    /**
     * Remove extra ingredients from the sandwich.
     * @param event pressing the remove button.
     */
    @FXML
    void clearIngredientsButton(ActionEvent event) {
    	clearIngredients();
    }

    /**
     * Remove selected ingredient from extra ingredients on sandwich.
     * @param event clicking remove button and selecting an extra.
     */
    @FXML
    void removeIngredients(ActionEvent event) {
    	String selected = addedIngredients.getSelectionModel().getSelectedItem();
    	if (selected != null) {
    		addedIngredients.getItems().remove(selected);
    		Extra extra = new Extra(selected);
    		sandwich.remove(extra);
    		
    		extraIngredients.getItems().add(selected);
        	String sandwichPrice = "$" + String.format("%,.2f", sandwich.price());
        	priceTextArea.setText(sandwichPrice);
    	}

    }
    
	
    /**
     * Prepare main window with default values and images.
     */
    @FXML
	public void initialize() {
		sandwichType.setValue("Chicken");
		sandwichType.setItems(sandwiches);
		sandwich = new Chicken();
    	String sandwichPrice = "$" + String.format("%,.2f", sandwich.price());
    	priceTextArea.setText(sandwichPrice);
		ingredients.addAll("Fried Chicken",
				"Spicy Sauce",
				"Pickles");
		
		ingredientListView.getItems().addAll(ingredients);

		addOnToppings.addAll("Lettuce", "Tomatoes", "Onion", "Bacon",
					"Mushrooms", "Spinach", "Pickles", "Provolone", "American", "Swiss");
		
		extraIngredients.getItems().addAll(addOnToppings);
		Image im = new Image("https://cdn.cnn.com/cnnnext/dam/assets/200522115738-20200522-kfc-chicken-sandwich-super-tease.jpg");
		sandwichPic.setImage(im);
	}
	
	/**
	 * Checks if there is room to add an extra ingredient 
	 * @return true if valid, false otherwise
	 */
	boolean validExtraIngredient() {
        Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.ERROR); 
        a.setContentText("CANNOT ADD MORE THAN 6 EXTRA INGREDIENTS!"); 
    	String[] addedIngredients_array = (String.join(", ", addedIngredients.getItems())).split(",");	//Converts listview to array
    	if ( addedIngredients_array.length == 6 ) {
    		a.show();
    		return false;
    	}
    	return true;
	}
}
