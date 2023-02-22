/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;

import PIServices.ServiceUser;
import PIClass.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginAffichController implements Initializable {

    @FXML
    private Button btnEdit;
    @FXML
    private Button btnSignOut;
    @FXML
    private Label lbUsername;
    @FXML
    private Label lbMail;
    @FXML
    private Label lbDate;
    @FXML
    private TableColumn<?, ?> colnom;
    @FXML
    private TableColumn<?, ?> colcin;
    @FXML
    private TableColumn<?, ?> colmdp;
    @FXML
    private Button btnSupp;
    @FXML
    private TableView<User> tv;
    @FXML
    private TableColumn<?, ?> colemail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        ServiceUser ps = new ServiceUser();
    ArrayList<User> publiciteList =  (ArrayList<User>) ps.afficher() ;
    ObservableList<User> data = FXCollections.observableArrayList(publiciteList); 
        tv.setItems(data);
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom_client"));
        colcin.setCellValueFactory(new PropertyValueFactory<>("cin_client"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email_client"));
        colmdp.setCellValueFactory(new PropertyValueFactory<>("pass_client"));
        
        
        
        
        
        
    }    

    @FXML
    private void edit(ActionEvent event) {
    }

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void signout(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
        
        
        
        User selectedItem = tv.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Etes vous sure de supprimer cette element ?");   
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        ServiceUser ps = new ServiceUser(); 
        tv.getItems().remove(selectedItem);
        ps.supprimer(selectedItem);
        }
        
        }
        else {
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un element à supprimer.");

        alert.showAndWait();
        }

        
        
        
        
        
        
        
    }
    
}
