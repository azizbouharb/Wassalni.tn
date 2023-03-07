/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maissa
 */
import projet.entities.Annonces;
import projet.entities.Alerts;
import java.sql.*;
import java.util.Date;
import projet.service.ServiceAnnonce;
import projet.service.AlertsService;
import java.util.Iterator;
import Projet.utils.MyConnection;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class NewMain extends Application {

    /**
     *
     * @param args the command line arguments
     */
    public void start(Stage primaryStage) throws IOException {

        //Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/AlertsFGUI.fxml"));
        //  Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/WebFXML.fxml"));
        //  Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/MusicFXML.fxml"));
       // Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/AnnonceFXML.fxml"));
        //Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/DetailController.fxml"));
        //Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/Statann.fxml"));
        //Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/Historique.fxml"));
       Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/Affichage_Ann.fxml"));
        // Parent parentPage = FXMLLoader.load(getClass().getResource("/interfaces/MusicFXML.fxml"));

        Scene scene = new Scene(parentPage);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        // TODO code application logic here

        MyConnection.getInstance();
        launch(args);

        //Annonces p;        
        //  p = new Annonces( "10-2-2022", "tunes", "bizerte", 1, 2); 
        // Annonces p1 = new Annonces("tunis", "bizert", "hgf", 0, 0);
        //Annonces p2=new Annonces(13,"" , "", "", 0, 0);
        // ServiceAnnonce Service= new ServiceAnnonce();
        Alerts pa = new Alerts(11, "hello", "hhhh");
        AlertsService sv = new AlertsService();
        System.out.println(sv.ajouter(pa));

        //System.out.println( Service.ajouter(p));
        // System.out.println( Service.afficher(p));
        // System.out.println( Service.modifier(p));
        // System.out.println(Service.afficher());
        // System.out.println(Service.modifier());
        //Service = System.out.println(Service.supprimer(p));
        //Service.modifier(p);
        //Service.afficher();
    }

}
