/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projet.entities.Alerts;
import projet.service.AlertsService;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class AlertsController implements Initializable {

    @FXML
    private AnchorPane brand;
    @FXML
    private TextField localisation;
    @FXML
    private TextField mail;
    @FXML
    private TextArea rapport;
    @FXML
    private Button envoyeralert;
    @FXML
    private TextField telephone;
    @FXML
    private DatePicker date;
    @FXML
    private ComboBox<?> programme_id;
    @FXML
    private Pane pane_m;
    @FXML
    private Button to_profile;
    @FXML
    private Button to_panier;
    @FXML
    private Label Annonces;
    @FXML
    private Button Annonce;
    @FXML
    private Button Locaux;
    @FXML
    private Button to_menu;
    @FXML
    private Label Propositions;
    @FXML
    private Button Accueil;
    @FXML
    private Button Alert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        AlertsService sl= new AlertsService();
          List <Alerts> l2= new ArrayList<Alerts>();
           ObservableList <Alerts> ls;
        
        
        
    }    

    @FXML
    private void envoyeralert(ActionEvent event) {
        
         if(localisation.getText().isEmpty()||telephone.getText().isEmpty()||rapport.getText().isEmpty()||mail.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        }if(localisation.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        
        }else if (!mail.getText().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$"))
        {
            JOptionPane.showMessageDialog(null, "Veuillez une adresse mail valide !"); 
        }     
        else
        {
        String Email = mail.getText();
        int telephon = Integer.parseInt(telephone.getText());
        String destination = localisation.getText();
        Date datee=java.sql.Date.valueOf(date.getValue());
         String Rapport = rapport.getText();
       
       Alerts a = new Alerts(1, localisation.getText(),"15-20-2020", rapport.getText(), Integer.valueOf(telephone.getText()),mail.getText());
       
         
        AlertsService sc = new AlertsService();
        sc.ajouter(a);
         JOptionPane.showMessageDialog(null, "ajout avec succes");
                 
        localisation.clear();
        rapport.clear();
        telephone.clear();
        mail.clear();    
       

        }
        
        
   
    }

   
    @FXML
    private void to_alert(ActionEvent event) throws IOException {
        
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/AlertsGUI.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        
    }
    
}
