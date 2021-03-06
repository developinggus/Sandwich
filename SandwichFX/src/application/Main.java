/**
 * This class runs all other classes.
 * @author Joseph Hawkins, Gustavo Garcia
 */
package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	/**
	 * Opens the landing window of our project.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Primary.fxml"));
			Scene scene = new Scene(root,600,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Gus & Joe's Sandwiches");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main that we need to run to get window.
	 * @param args command line arguments, there are none.
	 */
	public static void main(String[] args) {	
		launch(args);
	}
}
