/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.interfaces;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projet.entities.Location;
import projet.service.ServiceLocation;

/**
 * FXML Controller class
 *
 * @author bahar
 */
public class VoitureInterfaceController implements Initializable {
    
     Connection cnx;
    PreparedStatement ste;

    @FXML
    private Button btnajout;
    @FXML
    private Button btnmod;
    @FXML
    private Button btnsup;
    @FXML
    private Button btngoto;
    @FXML
    private TableView<Location> tv;
    @FXML
    private TableColumn<Location, Integer> colId_location;
    @FXML
    private TableColumn<Location, String> colDate_debut;
    @FXML
    private TableColumn<Location, String> colDate_fin;
    @FXML
    private TableColumn<Location, Integer> colPrix;
    @FXML
    private TableColumn<Location, Integer> colId_voiture;
    @FXML
    private TextField txtPrix;
    @FXML
    private TextField txtId_voiture;
    @FXML
    private TextField txtDate_debut;
    @FXML
    private TextField txtDate_fin;
    
    ServiceLocation sl= new ServiceLocation();
          List <Location> l2= new ArrayList<Location>();
           ObservableList <Location> ls;
           
           
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ls = FXCollections.observableArrayList();
    colId_location.setCellValueFactory(
            new PropertyValueFactory<Location, Integer>("id_location"));
    colDate_debut.setCellValueFactory(
            new PropertyValueFactory<Location, String>("date_debut"));
    colDate_fin.setCellValueFactory(
            new PropertyValueFactory<Location, String>("date_fin"));
    colPrix.setCellValueFactory(
            new PropertyValueFactory<Location, Integer>("prix_location"));
    colId_voiture.setCellValueFactory(
            new PropertyValueFactory<Location, Integer>("id_voiture"));

  
    ServiceLocation sl = new ServiceLocation();
    List<Location> l2 = sl.afficher();
    ls.addAll(l2);

    tv.setItems(ls);


    tv.setOnMouseClicked(e -> {
        if (e.getClickCount() == 2) {
            Location r = tv.getSelectionModel().getSelectedItem();
            if (r != null) {
                txtDate_debut.setText(r.getDate_debut());
                txtDate_fin.setText(r.getDate_fin());
                txtPrix.setText(Integer.toString(r.getPrix_location()));
                txtId_voiture.setText(Integer.toString(r.getId_voiture()));
            }
        }
    });

    } 
    
     @FXML
    private void deleteLocation(ActionEvent event) {
        
         Location selectedItem = tv.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
       //Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.setTitle("Confirmation Dialog");
        //alert.setContentText("Etes vous sure de supprimer cette element ?");   
       // Optional<ButtonType> result = alert.showAndWait();
       // if (result.get() == ButtonType.OK){
        ServiceLocation ps = new ServiceLocation(); 
        tv.getItems().remove(selectedItem);
        ps.supprimer(selectedItem);
        }
        
        }
    
     @FXML
private void modifierLocation(ActionEvent event) {
    Location r = tv.getSelectionModel().getSelectedItem();
    if (r != null) {
        Integer id_location = r.getId_location();
        String date_debut = txtDate_debut.getText();
        String date_fin = txtDate_fin.getText();
        Integer prix_location = Integer.valueOf(txtPrix.getText());
        Integer id_voiture = Integer.valueOf(txtId_voiture.getText()); 
        
        // ybadel les valeur ta3 la location selectionee 
        r.setDate_debut(date_debut);
        r.setDate_fin(date_fin);
        r.setPrix_location(prix_location);
        r.setId_voiture(id_voiture);
        
        
        ServiceLocation rm = new ServiceLocation();
        rm.modifier(r);
        
        // mise a jour ta3 el tableau
        ArrayList<Location> publiciteList = (ArrayList<Location>) rm.afficher();
        ObservableList<Location> donnee = FXCollections.observableArrayList(publiciteList); 
        tv.setItems(donnee);
    }
}
    
    @FXML
private void addLocation(ActionEvent event) {

    if (txtDate_debut.getText().isEmpty() || txtDate_fin.getText().isEmpty() || txtPrix.getText().isEmpty() || txtId_voiture.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
    } else {
        String date_debut = txtDate_debut.getText();
        String date_fin = txtDate_fin.getText();
        Integer prix_location = 0;
        Integer id_voiture = Integer.parseInt(txtId_voiture.getText());

       
        if (!date_debut.matches("\\d{4}-\\d{2}-\\d{2}") || !date_fin.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(null, "Les dates doivent être au format 'YYYY-MM-DD'.");
        } else {
            // 
            String[] debutParts = date_debut.split("-");
            String[] finParts = date_fin.split("-");
            int debutYear = Integer.parseInt(debutParts[0]);
            int debutMonth = Integer.parseInt(debutParts[1]);
            int debutDay = Integer.parseInt(debutParts[2]);
            int finYear = Integer.parseInt(finParts[0]);
            int finMonth = Integer.parseInt(finParts[1]);
            int finDay = Integer.parseInt(finParts[2]);
            if (debutYear > finYear || (debutYear == finYear && (debutMonth > finMonth || (debutMonth == finMonth && debutDay > finDay)))) {
                JOptionPane.showMessageDialog(null, "La date de début doit être antérieure à la date de fin.");
            } else {
                // prix location lezm ykoun entier
                try {
                    prix_location = Integer.parseInt(txtPrix.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Le prix doit être un entier.");
                    return;
                }

                Location c = new Location(date_debut, date_fin, prix_location, id_voiture);
                ServiceLocation sc = new ServiceLocation();
                sc.ajouter(c);
                JOptionPane.showMessageDialog(null, "Ajout effectué avec succès.");
                txtDate_debut.clear();
                txtDate_fin.clear();
                txtPrix.clear();
                txtId_voiture.clear();

                ls.addAll(sl.afficher());
                tv.setItems(ls);

                JOptionPane.showMessageDialog(null, "Affichage effectué avec succès.");
            }
        }
    }
}
    
    @FXML
    private void to_Voiture(ActionEvent event) throws IOException {
        
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/projet/interfaces/Voiture2.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
