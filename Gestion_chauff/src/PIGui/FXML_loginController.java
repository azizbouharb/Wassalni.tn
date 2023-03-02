/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;
import PIClass.Chauffeur;

import PIServices.ServiceChauffeur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Aziz Bouharb
 */
public class FXML_loginController implements Initializable {
     @FXML
    private TextField tf_mail;
    @FXML
    private Button btnlogin;
    @FXML
    private Button btncancel;
    @FXML
    private PasswordField tf_pass;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void loginN(ActionEvent event) throws IOException
    {
        ServiceChauffeur sU = ServiceChauffeur.getInstance();
		Chauffeur u = sU.login(tf_mail.getText(), tf_pass.getText());
		if (u.getId_client()> -1) {                                                 
                    
            JOptionPane.showMessageDialog(null,"Bienvenue ");
			FXMLLoader loader1= new FXMLLoader(getClass().getResource("Profil_chauf.fxml"));              
			Parent root1= loader1.load();
			tf_mail.getScene().setRoot(root1);

           Profil_chaufController controller = (Profil_chaufController) loader1.getController();
            controller.setChauf(u);
            controller.setLbMat(u.getId_voiture());
			controller.refresh();
		}
		else {
			
            JOptionPane.showMessageDialog(null,"Mot de passe ou login incorrect ");
             
		}
    }
    
    @FXML
    private void cancel(ActionEvent event) throws IOException 
    {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Acceuil.fxml"));
        Parent root= loader.load();
        btncancel.getScene().setRoot(root);
    }
    
}
