/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMain;

import PIClass.Location;
import PIClass.Voiture_location;

import java.sql.*;
import java.util.Date;
import PIServices.ServiceLocation;
import PIServices.ServiceVoiture;


import java.util.Iterator;
import PIUtils.MyConnection;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.application.Application;
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

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Location l = new Location(40,"2023-01-21", "2023-02-28", 14);
       
        ServiceLocation Service1 = new ServiceLocation();
       //System.out.println( Service1.ajouter(l));
        //Service1.supprimer(l);
        Service1.modifier(l);
       //System.out.println(Service1.afficher());
       
       //Voiture_location v = new Voiture_location("98TUN1060","peugeot 106","1438",54);
       //ServiceVoiture Service = new ServiceVoiture();
      //System.out.println( Service.ajouter(v));
       //System.out.println(Service.afficher());
        //System.out.println(Service.rechercher("k"));
    }
    
}