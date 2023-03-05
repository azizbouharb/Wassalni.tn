/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author bahar
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
      Parent root = FXMLLoader.load(getClass().getResource("Interface/ModifierLocation.fxml"));
      primaryStage.setTitle("Location");
      primaryStage.setScene(new Scene(root, 1000,700));
      primaryStage.show();
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

