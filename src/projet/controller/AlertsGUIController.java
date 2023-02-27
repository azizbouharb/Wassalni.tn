/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projet.entities.Alerts;
import projet.service.AlertsService;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class AlertsGUIController implements Initializable {

    @FXML
    private AnchorPane AnO;
    @FXML
    private TableView<Alerts> affichealert;
    @FXML
    private TableColumn<?, ?> localisations;
    @FXML
    private TableColumn<?, ?> dates;
    @FXML
    private TableColumn<?, ?> rapports;
    @FXML
    private TableColumn<?, ?> telephones;
    @FXML
    private TableColumn<?, ?> mails;
    @FXML
    private TextField recherchealert;
    @FXML
    private Button delete;
    @FXML
    private Button print;
    @FXML
    private Button closeb;
    @FXML
    private VBox Activite_menu;
    @FXML
    private VBox Convention_menu;
    @FXML
    private VBox Transport_menu;
    @FXML
    private VBox Produit_menu;
    @FXML
    private VBox Fonctionnalites_menu;
    @FXML
    private Button Annonce;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AlertsService ps = new AlertsService();
    ArrayList<Alerts> publiciteList =  (ArrayList<Alerts>) ps.afficher() ;
    ObservableList<Alerts> data = FXCollections.observableArrayList(publiciteList); 
        affichealert.setItems(data);
        localisations.setCellValueFactory(new PropertyValueFactory<>("destination"));
        dates.setCellValueFactory(new PropertyValueFactory<>("date"));
        rapports.setCellValueFactory(new PropertyValueFactory<>("rapport"));
        telephones.setCellValueFactory(new PropertyValueFactory<>("Num_tel"));
        mails.setCellValueFactory(new PropertyValueFactory<>("mail"));
    }    

    @FXML
    private void delete(ActionEvent event) {
        
        Alerts selectedItem = affichealert.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Etes vous sure de supprimer cette element ?");   
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        AlertsService ps = new AlertsService() ; 
        affichealert.getItems().remove(selectedItem);
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

    @FXML
    private void print(ActionEvent event) {
    }

   

    private void To_Annonces(ActionEvent event) throws IOException {
        
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/AnnoncesbackController.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

  
    @FXML
    private void Close(ActionEvent event) {
              Stage window = (Stage) closeb.getScene().getWindow();
        window.close();
    }
    
    @FXML
    private void to_Annonce(ActionEvent event) throws IOException {
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Annonceback.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
    }

   
    
}
