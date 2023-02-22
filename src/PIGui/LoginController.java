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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javafx.util.*;

import javax.swing.JOptionPane;
import org.controlsfx.control.action;


/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {

    @FXML
     private TextField log_Email;
    @FXML
     private TextField log_pass;
    @FXML
    private Button bt_log;
    
    
     
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private void log_in(ActionEvent event) throws IOException{
        if ( log_Email.getText().isEmpty() | log_pass.getText().isEmpty())
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez remplir les champs vides ! ");
            al.showAndWait();
        }
        else if (!log_Email.getText().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$"))
        {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Veuillez une adresse mail valide ! ");
            a2.showAndWait();
        }
        
        ServiceUser ps = new ServiceUser(); 
      
       User u= ps.login(log_Email.getText(),log_pass.getText());
        if(u.getId_client()>-1){
        Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Succee ! ");
            al.showAndWait();
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Userprofile.fxml"));
            Parent root= loader.load();
            log_Email.getScene().setRoot(root);
        }else{
        Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("pass ou login incorrect ! ");
            al.showAndWait();
        }
       
    }

   
    
}
   


