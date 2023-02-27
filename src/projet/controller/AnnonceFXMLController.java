/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projet.entities.Alerts;
import projet.entities.Annonces;
import projet.service.AlertsService;
import projet.service.ServiceAnnonce;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class AnnonceFXMLController implements Initializable {

    @FXML
    private TextField txtdepart;
    @FXML
    private TextField txtdestination;
    @FXML
    private DatePicker txtdate;
    @FXML
    private TextField txtdispo;
    @FXML
    private Button envoyer;
    @FXML
    private TextField txtnum;
    @FXML
    private Button closeb;
    @FXML
    private ImageView myimageview;

    /**
     * Initializes the controller class.
     */
    
    
   // Image monImage = new Image(getClass().getResourceAsStream("/image/Wassalni-removebg-preview.png"));
    
    
    
 
           
    
       Image image=new Image("/image/wassalni-removebg-preview.png");
     public void displayImage() {
              myimageview.setImage(image);
            }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          
      
        
          ServiceAnnonce sc= new ServiceAnnonce();
          List <Annonces> l2= new ArrayList<Annonces>();
           ObservableList <Alerts> ls;
        // TODO
    }    

    @FXML
    private void envoyerannonce(ActionEvent event) {
        
        
          if(txtdepart.getText().isEmpty()||txtdestination.getText().isEmpty()||txtdispo.getText().isEmpty()||txtnum.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        } else if(txtdepart.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        
        }   else if(txtdestination.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        
        }   
        else
        {
        String depart =txtdepart.getText();
        int Num = Integer.parseInt(txtnum.getText());
        String Destination = txtdestination.getText();
        Date Date=java.sql.Date.valueOf(txtdate.getValue());
         String Disponibilite = txtdispo.getText();
       
        Annonces a=new Annonces("15-20-2020", txtdestination.getText() ,  txtdepart.getText(), Integer.valueOf(txtdispo.getText()) , Integer.valueOf(txtnum.getText()));
         
        ServiceAnnonce sc = new ServiceAnnonce();
                    sc.ajouter(a);
         JOptionPane.showMessageDialog(null, "ajout avec succes");
                 
        txtdepart.clear();
        txtdestination.clear();
        txtdispo.clear();
        txtnum.clear();    
        

        }
        
        
        
        
        
    }

    @FXML
    private void close(ActionEvent event) {
        
         Stage window = (Stage) closeb.getScene().getWindow();
        window.close();
    }
    
    
    
    
    
}
