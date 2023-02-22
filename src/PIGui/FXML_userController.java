/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;

import PIClass.User;
import PIServices.ServiceUser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXML_userController implements Initializable {

   
 @FXML
    private TextField bt_Nom;
    @FXML
    private PasswordField bt_pass;
    @FXML
    private TextField bt_Cin;
   
    @FXML
    private TextField bt_Email;
     
    @FXML
    private Button bt_confirm;
    @FXML
    private Button bt_annuler;
    @FXML
    private Button afficher;
    
    /**
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void ajouter_User(ActionEvent event) throws IOException 
    {      
      
        if ( bt_Cin.getText().isEmpty() | bt_Email.getText().isEmpty() | bt_Nom.getText().isEmpty() | bt_pass.getText().isEmpty() )
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez remplir les champs vides ! ");
            al.showAndWait();
        }
       
        else if (!bt_Email.getText().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$"))
        {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Veuillez une adresse mail valide ! ");
            a2.showAndWait();
        }
        else if (bt_Nom.getText().equals(bt_pass.getText()))
        {
            Alert a3 = new Alert(Alert.AlertType.ERROR);
            a3.setHeaderText(null);
            a3.setContentText("Veuillez ne pas mettre votre nom en tant que mot de passe ! ");
            a3.showAndWait();
        }
        else
        { 
            int cin = Integer.valueOf(bt_Cin.getText());
            ServiceUser sc= new ServiceUser();
            sc.ajouter(new User(bt_Nom.getText(),cin,bt_Email.getText(),bt_pass.getText() )) ;

            JOptionPane.showMessageDialog(null,"Welcome ");

            FXMLLoader loader= new FXMLLoader(getClass().getResource("FXML_user.fxml"));
            Parent root= loader.load();
            bt_Nom.getScene().setRoot(root);

          
        }
    }
   
    @FXML
    private void cancel_create(ActionEvent event) throws IOException 
    {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("FXML_user.fxml"));
        Parent root= loader.load();
        bt_annuler.getScene().setRoot(root);
    }

   

   
}
