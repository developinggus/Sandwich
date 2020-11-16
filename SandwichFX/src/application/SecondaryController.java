/**
 * This is the controller for the second window that shows all the sandwiches on an order.
 * @author Joseph Hawkins, Gustavo Garcia
 */
package application;

import java.util.ArrayList;
import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SecondaryController {
	private ArrayList<OrderLine> order;
	
    @FXML
    private TextArea OrderTotalTextArea;

    @FXML
    private ListView<String> orderSummary;
    
    @FXML
    private Button backButton;
    
    /**
     * Clear order
     * @param event
     */
    @FXML
    void clearOrderButton(ActionEvent event) {

    }

    /**
     * Close window when back button is pressed.
     * @param event back button is pressed.
     */
    @FXML
    void goBack(ActionEvent event) {
	    Stage stage = (Stage) backButton.getScene().getWindow();
	    stage.close();
    }
    
    /**
     * Prepare secondary window with order values.
     */
    @FXML
	public void loadOrderListView() {
    	Collection<String> tempOrders = new ArrayList<String>();
    	for(int i = 0; i < order.size(); i++) {
    		 tempOrders.add(order.get(i).toString()); 
    	}
    	orderSummary.getItems().addAll(tempOrders);
	}
    public void initData(ArrayList<OrderLine> orders) {
    	order = orders;
    }

}

