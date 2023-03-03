/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import projet.entities.Location;
import projet.entities.Voiture;

import java.sql.*;
import java.util.Date;
import projet.service.ServiceLocation;
import projet.service.ServiceVoiture;

import java.util.Iterator;
import Projet.utils.MyConnection;
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
        Voiture p = new Voiture(5, "212tunis8040", "kia sportage", "14532234");
        Voiture  p1 = new Voiture( 6,"161tunis9000", "hyundai i10", "587834");
        ServiceVoiture Service = new ServiceVoiture();
        //System.out.println( Service.ajouter(p));
        //Service.supprimer(p);
        //Service.modifier(p);
        System.out.println(Service.afficher());
        
        
        Location l = new Location(1, "2022-08-15", "2022-08-22", 1555,8);
        Location  l1 = new Location( "2023-01-02", "2023-02-12", 3600,7);
        ServiceLocation Service1 = new ServiceLocation();
       // System.out.println( Service1.ajouter(l1));
        //Service1.supprimer(l);
        //Service1.modifier(l);
       //System.out.println(Service1.afficher());
        
    }
    
}
