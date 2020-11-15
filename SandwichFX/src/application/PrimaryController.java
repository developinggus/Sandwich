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
    

    @FXML
    void newSandwichSelected(ActionEvent event) {
    	//
    	String selection = sandwichType.getValue();
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
    	
    	String[] addedIngredients_array = (String.join(", ", addedIngredients.getItems())).split(",");	//Converts listview to array
    	
    	for (int i = 0; i < addedIngredients_array.length; i++) {	//transfer extras onto the new sandwich
    		Extra temp_extra = new Extra(addedIngredients_array[i]);
    		sandwich.add(temp_extra);
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
    	if (!validExtraIngredient()) {
    		return;
    	}
    	String selected = extraIngredients.getSelectionModel().getSelectedItem();
    	if (selected != null) {
    		extraIngredients.getItems().remove(selected);
    		addedIngredients.getItems().add(selected);
    		Extra topping = new Extra(selected);
    		sandwich.add(topping);
    		priceTextArea.setText("$" + String.valueOf((sandwich.price())));
    	}
    }

    @FXML
    void clearIngredients(ActionEvent event) {
    	/* DOES NOT WORK IDK WHY
    	String[] addedIngredients_array = (String.join(", ", addedIngredients.getItems())).split(",");	//Converts listview to array
    	for (int i = 0; i < addedIngredients_array.length; i++) {
    		addedIngredients.getItems().remove(addedIngredients_array[i]);
    		extraIngredients.getItems().add(addedIngredients_array[i]);
    	}
    	*/
 
    }

    @FXML
    void removeIngredients(ActionEvent event) {
    	String selected = addedIngredients.getSelectionModel().getSelectedItem();
    	if (selected != null) {
    		addedIngredients.getItems().remove(selected);
    		extraIngredients.getItems().add(selected);
    		priceTextArea.setText("$" + String.valueOf((sandwich.price())));
    	}

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
		
		extraIngredients.getItems().addAll(addOnToppings);
		Image im = new Image("https://cdn.cnn.com/cnnnext/dam/assets/200522115738-20200522-kfc-chicken-sandwich-super-tease.jpg");
		sandwichPic.setImage(im);
	}
	
	public void loadIngredients() {
		
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
