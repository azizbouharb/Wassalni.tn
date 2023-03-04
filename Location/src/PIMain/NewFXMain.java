/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMain;

import java.sql.*;
import java.util.Date;
import PIServices.ServiceVoiture;
import PIServices.ServiceLocation;

import java.util.Iterator;
import PIUtils.MyConnection;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author bahar
 */
public class NewFXMain extends Application {

    public void start(Stage primaryStage) throws Exception {

        Parent parentPage = FXMLLoader.load(getClass().getResource("/PIGui/AfficherLocationGui.fxml"));
        Scene scene = new Scene(parentPage);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
