package application;

import javafx.collections.FXCollections;
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


    @FXML
    void newSandwichSelected(ActionEvent event) {
    	//
    	String selection = sandwichType.getValue();
    	if(selection.equals("Chicken")) {
    		sandwich = new Chicken();
    	}
    	if(selection.equals("Fish")) {
    		sandwich = new Fish();
    	}
    	if(selection.equals("Beef")) {
    		sandwich = new Beef();
    	}

    	priceTextArea.setText("$" + String.valueOf((sandwich.price())));
    	//change priceTextArea based on sandwich selected
    	
    }
    
    /**
     * Adjusts the price of a sandwich based on the current toppings.
     */
    void adjustPrice() {
    	
    }
    
    @FXML
    void AddIngredients(ActionEvent event) {

    }

    @FXML
    void clearIngredients(ActionEvent event) {

    }

    @FXML
    void removeIngredients(ActionEvent event) {

    }
    
	@FXML
	public void initialize() {
		sandwichType.setValue("Chicken");
		sandwichType.setItems(sandwiches);
		sandwich = new Chicken();
    	priceTextArea.setText("$" + String.valueOf((sandwich.price())));
		ingredients.addAll("Fried Chicken",
				"Spicy Sauce",
				"Pickles");
		
		ingredientListView.getItems().addAll(ingredients);

		addOnToppings.addAll("Lettuce", "Tomatoes", "Onion", "Bacon",
					"Mushrooms", "Spinach", "Pickles", "Provolone", "American", "Swiss");
		
		//extraIngredients.getItems().addAll(addOnToppings);
	}
	
	public void loadIngredients() {
		
	}
}
