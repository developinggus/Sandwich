/**
 * This is the controller for the second window that shows all the sandwiches on an order.
 * @author Joseph Hawkins, Gustavo Garcia
 */
package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class SecondaryController {

	private PrimaryController primary;

	private ArrayList<OrderLine> order;

    @FXML
    private TextArea orderTotalTextArea;

    @FXML
    private ListView<String> orderSummary;

    @FXML
    private Button backButton;

    /**
     * constructor for this class.
     */
    public SecondaryController() {

    }

    /**
     * Clear order
     * @param event clear button pressed.
     */
    @FXML
    void clearOrderButton(ActionEvent event) {
    	clearOrderSummary();
    	primary.clearOrderSummary();
    	order = null;
    	closeWindow();
    }

    /**
     * closes the secondary window
     */
    void closeWindow() {
	    Stage stage = (Stage) backButton.getScene().getWindow();
	    stage.close();
    }

    /**
     * Clears order.
     */
    void clearOrderSummary() {
    	if(orderSummary == null) {
    		return;
    	}
    	orderSummary.getItems().clear();
    }

    /**
     * Close window when back button is pressed.
     * @param event back button is pressed.
     */
    @FXML
    void goBack(ActionEvent event) {
    	closeWindow();
    }

    /**
     * Prepare secondary window with order values.
     */
    @FXML
	public void loadOrderListView() {
    	if(order == null) {
    		orderSummary.getItems().addAll("");
    		return;
    	}

    	Collection<String> tempOrders = new ArrayList<String>();
    	for(int i = 0; i < order.size(); i++) {
    		 tempOrders.add(order.get(i).toString());
    	}
    	orderSummary.getItems().clear();
    	orderSummary.getItems().addAll(tempOrders);
    	updateTotal();
	}

    /**
     * Passing information back and forth between controllers.
     * @param orders sandwiches ordered by user on primary controller.
     */
    public void initialize(ArrayList<OrderLine> orders, PrimaryController primary) {
    	if(orders != null) {
    		order = orders;
    	}
    	else {
    		order = new ArrayList<OrderLine> ();
    	}
    	this.primary = primary;

    }

    /**
     * export accounts from database to txt file
     * @param event clicking export menu button
     */
    @FXML
    private void exportFile(ActionEvent event) {
    	FileChooser chooser = new FileChooser();
    	chooser.setTitle("Open Target File for the Export");
    	chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
    			new ExtensionFilter("All Files", "*.*"));
    	Stage stage = new Stage();
    	File targetFile = chooser.showSaveDialog(stage);
    	if ( targetFile != null ) {
    		try {		
    			PrintWriter writer;
    			writer = new PrintWriter(targetFile);
    			writeToFile(writer);
    		} catch (IOException ex) {
    			//messageArea.appendText("Unable to export order.");
    		}
    	}
    	//export accounts database to a txt file
    }

    /**
     * Duplicates an order in order summary
     * @param event is the action of the button "Same order line"
     */
    public void sameOrderLine(ActionEvent event) {
	  String selected = orderSummary.getSelectionModel().getSelectedItem();
	  if ( selected == null ) {
	        Alert a = new Alert(AlertType.NONE);
	        a.setAlertType(AlertType.ERROR);
	        a.setContentText("Please select an item to add!");
	        a.show();
		  return;
	  }
	  String[] selected_array = selected.split(" ");

	  for (int i = 0; i < order.size(); i++) {
		  if ( order.get(i).getLineNumber() == Integer.parseInt(selected_array[0])) {
			  OrderLine same_order = new OrderLine(order.size() + 1, order.get(i).getSandwich(), order.get(i).getPrice());
			  primary.order.add(same_order);
		      order = primary.order.getOrders();
		      loadOrderListView();
		      return;

		  }
	  }
	  return;

  }

    /**
     * Takes the order summary and writes it to a text file.
     * @param writer the printwriter for the file we write the order summary to.
     */
    public void writeToFile(PrintWriter writer){
    	int size = orderSummary.getItems().size();

    	for(int i = 0; i < size; i++) {
        	writer.println(orderSummary.getItems().get(i));
        }

        writer.close();
    }

    /**
     * Remove the selected orderline.
     * @param event clicked remove button.
     */
    @FXML
    void removeOrderLine(ActionEvent event) {
    	//what if nothing is selected??

    	String selection = orderSummary.getSelectionModel().getSelectedItem();
    	if(selection == null) {
	        Alert a = new Alert(AlertType.NONE);
	        a.setAlertType(AlertType.ERROR);
	        a.setContentText("Please select an item to remove!");
	        a.show();
    		return;
    	}
    	int lineNumber = Integer.parseInt(selection.split(" ")[0]);
    	OrderLine orderline = new OrderLine(lineNumber, null, 0);
    	primary.order.remove(orderline);
    	order = primary.order.getOrders();
    	loadOrderListView();
    }

    /**
     * updates the text area for total cost of order.
     */
    private void updateTotal() {
    	int numSandwiches = order.size();
    	double total = 0;
    	for(int i = 0; i < numSandwiches; i++) {
    		total += order.get(i).getPrice();
    	}
    	orderTotalTextArea.setText("$" 
    	+ String.format("%,.2f", total));
    }

}
