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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class SecondaryController {
	
	private PrimaryController primary;
	
	private ArrayList<OrderLine> order;
	
    @FXML
    private TextArea OrderTotalTextArea;

    @FXML
    private ListView<String> orderSummary;
    
    @FXML
    private Button backButton;
    
    /**
     * Constructor for secondary Controller
     * @param primary main controller reference is passed into this class.
     */
    public SecondaryController(PrimaryController primary) {
    	this.primary = primary;
    }
    
    /**
     * Clear order
     * @param event
     */
    @FXML
    void clearOrderButton(ActionEvent event) {
    	clearOrderSummary();
    	primary.clearOrderSummary();
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
	    Stage stage = (Stage) backButton.getScene().getWindow();
	    stage.close();
    }
    
    /**
     * Prepare secondary window with order values.
     */
    @FXML
	public void loadOrderListView() {
    	if(order == null) {
    		return;
    	}
    	// this method isn't getting the correct order number.
    	Collection<String> tempOrders = new ArrayList<String>();
    	for(int i = 0; i < order.size(); i++) {
    		 tempOrders.add(order.get(i).toString()); 
    	}
    	orderSummary.getItems().addAll(tempOrders);
	}
    
    /**
     * Passing information back and forth between controllers.
     * @param orders sandwiches ordered by user on primary controller.
     */
    public void initData(ArrayList<OrderLine> orders) {
    	order = orders;
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
}

