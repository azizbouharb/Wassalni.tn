/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;
import PIClass.Chauffeur;

import PIServices.ServiceChauffeur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Aziz Bouharb
 */
public class FXML_ChauffeurController implements Initializable {
    @FXML
    private Button upload_file;
    @FXML
    private TextField tfnom;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfpath;
    @FXML
    private TextField tfpermis;
     @FXML
    private TextField tfvoiture;
    @FXML
    private Button btnnext;
    @FXML
    private Button btnCancel;
    
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      
    }    
    
  
    @FXML
    private void ajouter_Chauffeur(ActionEvent event) throws IOException 
    {      
      
       

        
        if ( tfnom.getText().isEmpty() | tfpassword.getText().isEmpty() | tfemail.getText().isEmpty() | tfpermis.getText().isEmpty() )
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez remplir les champs vides ! ");
            al.showAndWait();
        }
       
        else if (!tfemail.getText().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$"))
        {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Veuillez une adresse mail valide ! ");
            a2.showAndWait();
        }
        
        else if (!tfpermis.getText().matches("\\d*"))
        {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Veuillez entrer que des chiffre en tant que permis ! ");
            a2.showAndWait();
        }
        else if (tfnom.getText().equals(tfpassword.getText()))
        {
            Alert a3 = new Alert(Alert.AlertType.ERROR);
            a3.setHeaderText(null);
            a3.setContentText("Veuillez ne pas mettre votre nom en tant que mot de passe ! ");
            a3.showAndWait();
        }
        else
        { 
            int permis = Integer.valueOf(tfpermis.getText());
            ServiceChauffeur sc= new ServiceChauffeur();
            sc.ajouter(new Chauffeur(permis,tfpath.getText(), tfvoiture.getText(), tfnom.getText(), tfemail.getText(),tfpassword.getText() )) ;

            JOptionPane.showMessageDialog(null,"Welcome sir ♥");

            FXMLLoader loader= new FXMLLoader(getClass().getResource("FXML_Voiture.fxml"));
            Parent root= loader.load();
            tfnom.getScene().setRoot(root);
            FXML_VoitureController pc= loader.getController();
         
            pc.setTfmat(tfvoiture.getText());
             pc.setNom(tfnom.getText());
            
          
        }
    }
    
    
     @FXML
       private String FileChooser(ActionEvent event) throws IOException 
    {
         String path;
        FileChooser fileChooser = new FileChooser();
     
        File selectedFile = fileChooser.showOpenDialog(null);
       
      path =  selectedFile.toString();
      tfpath.setText(path);
        return path;
        
        
        
    }
       
      
       
       
       
    @FXML
    private void cancel_create(ActionEvent event) throws IOException 
    {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Acceuil.fxml"));
        Parent root= loader.load();
        btnCancel.getScene().setRoot(root);
    }
}

  

