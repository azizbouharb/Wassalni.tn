/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;
import PIClass.Chauffeur;
import PIClass.Voiture;
import PIServices.ServiceVoiture;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Aziz Bouharb
 */
public class FXML_VoitureController implements Initializable {
    @FXML
    private TextField tf_mat;
    @FXML
    private TextField tfgrise;
    @FXML
    private TextField tfvoi;
    @FXML
    private TextField nom;
    
     @FXML
    private Button upload1;
     @FXML
    private Button upload2;
    /**
     * Initializes the controller class.
     */
    
    Voiture u = new Voiture();
    public void setVoiture(Voiture u) {
		this.u = u;
	}
	
	public void refresh() {
		tf_mat.setText(u.getMatricule());

	}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     public void setTfmat(String username) {
        this.tf_mat.setText(username);
    }
      public void setNom(String username) {
        this.nom.setText(username);
    }
    
      @FXML
    private void ajouter_Voiture(ActionEvent event) throws IOException 
    {      
      
       

        
        if ( tfvoi.getText().isEmpty() | tfgrise.getText().isEmpty() )
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez joindre tous les fichiers ! ");
            al.showAndWait();
        }
       
        
        else
        { 
           
            ServiceVoiture sc= new ServiceVoiture();
            sc.ajouter(new Voiture(tf_mat.getText(), tfvoi.getText(), tfgrise.getText())) ;

            JOptionPane.showMessageDialog(null,"Voiture bien enregistrer dans la base ");

            FXMLLoader loader= new FXMLLoader(getClass().getResource("Profil_chauf.fxml"));
            Parent root= loader.load();
            tf_mat.getScene().setRoot(root);
            Profil_chaufController pc= loader.getController();
         
            pc.setLbMat(tf_mat.getText());
            pc.setLbUsername(nom.getText());
          
        }
    }
    
    
     @FXML
       private String FileChooser1(ActionEvent event) throws IOException 
    {
         String path;
        FileChooser fileChooser = new FileChooser();
     
        File selectedFile = fileChooser.showOpenDialog(null);
       
      path =  selectedFile.toString();
      tfgrise.setText(path);
      
        return path;
        
        
        
    }
       
     @FXML
       private String FileChooser2(ActionEvent event) throws IOException 
    {
         String path;
        FileChooser fileChooser = new FileChooser();
     
        File selectedFile = fileChooser.showOpenDialog(null);
       
      path =  selectedFile.toString();
      tfvoi.setText(path);
      
        return path;
        
        
        
    }
      
    
}
