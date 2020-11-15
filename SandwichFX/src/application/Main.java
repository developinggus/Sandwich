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
	
	public static void main(String[] args) {
		
		Chicken beef_patty = new Chicken();
		Extra bacon = new Extra("bacon");
		beef_patty.add(bacon);
		OrderLine order = new OrderLine(5,beef_patty,beef_patty.price()); 
		Order wait_line = new Order();
		wait_line.add(order);
		//System.out.println(beef_patty.toString());
		
		
		launch(args);
	}
}
