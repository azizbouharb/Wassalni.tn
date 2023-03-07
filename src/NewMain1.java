
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import projet.entities.Alerts;
import projet.service.AlertsService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maissa
 */

 

public class NewMain1 {
    
    
    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alerts pa=new Alerts(8);
                       AlertsService sv=new AlertsService();
                         //System.out.println(sv.ajouter(pa));
                          System.out.println( sv.afficher());
                          sv.supprimer(pa);
        // TODO code application logic here
    }
    
}
