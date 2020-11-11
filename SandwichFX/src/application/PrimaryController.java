package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class PrimaryController {

	ObservableList<String> sandwiches = FXCollections
			.observableArrayList("Chicken", "Beef", "Fish");
	
	ObservableList<String> ingredients = FXCollections
			.observableArrayList();
	
    @FXML
    private ComboBox <String> sandwichTypeBox;
	
    @FXML
    private ListView <String> ingredientListView;
    
	@FXML
	public void initialize() {
		sandwichTypeBox.setValue("Chicken");
		sandwichTypeBox.setItems(sandwiches);
		
		
		//ingredientListView = new ListView<String>(ingredients);
		ingredients.addAll("Fried Chicken",
				"Spicy Sauce",
				"Pickles");
		ingredientListView.getItems().addAll(ingredients);
	}
	
	public void loadIngredients() {
		
	}
}
