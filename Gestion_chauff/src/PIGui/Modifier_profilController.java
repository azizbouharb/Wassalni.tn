/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;
import PIClass.Chauffeur;

import PIServices.ServiceChauffeur;
import PIServices.ServiceChauffeur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Aziz Bouharb
 */
public class Modifier_profilController implements Initializable {



    @FXML
    private TextField tfUsernameU;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnCancelU;
    @FXML
    private PasswordField tfPasswordU;
    @FXML
    private TextField tfMat;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) throws IOException 
    {
        if ( tfUsernameU.getText().isEmpty() | tfPasswordU.getText().isEmpty() | tfMat.getText().isEmpty() )
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez remplir les champs vides ! ");
            al.showAndWait();
        }
      
        else if (tfUsernameU.getText().equals(tfPasswordU.getText()))
        {
            Alert a3 = new Alert(Alert.AlertType.ERROR);
            a3.setHeaderText(null);
            a3.setContentText("Veuillez ne pas mettre votre username en tant que mot de passe ! ");
            a3.showAndWait();
        }
        else 
        {
            ServiceChauffeur sp= new ServiceChauffeur();
            sp.modifier(new Chauffeur(0, null, tfMat.getText(),tfUsernameU.getText(),null,tfPasswordU.getText() ) );

            JOptionPane.showMessageDialog(null,"Chauffeur modified");

             FXMLLoader loader= new FXMLLoader(getClass().getResource("Profil_chauf.fxml"));
            Parent root= loader.load();
            tfMat.getScene().setRoot(root);
            Profil_chaufController pc= loader.getController();
         
            pc.setLbMat(tfMat.getText());
            pc.setLbUsername(tfUsernameU.getText());
        }
        
    }

    @FXML
    private void cancelupdate(ActionEvent event) throws IOException {

        FXMLLoader loader= new FXMLLoader(getClass().getResource("Profil_chauf.fxml"));
        Parent root= loader.load();
        btnCancelU.getScene().setRoot(root);
        Profil_chaufController pc= loader.getController();
        pc.setLbMat(tfMat.getText());
            pc.setLbUsername(tfUsernameU.getText());
    }
    public void setName(String username) {
        this.tfUsernameU.setText(username);
    }
    public void setMat(String username) {
        this.tfMat.setText(username);
    }
   
}
