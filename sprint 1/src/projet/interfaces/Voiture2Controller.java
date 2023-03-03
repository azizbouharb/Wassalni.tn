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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projet.entities.Location;
import projet.entities.Voiture;
import projet.service.ServiceLocation;
import projet.service.ServiceVoiture;

/**
 * FXML Controller class
 *
 * @author bahar
 */
public class Voiture2Controller implements Initializable {
    
     Connection cnx;
    PreparedStatement ste;

    @FXML
    private TableView<Voiture> tv;
    @FXML
    private TableColumn<Voiture, Integer> colId_voiture;
    @FXML
    private TableColumn<Voiture, String> colMatricule;
    @FXML
    private TableColumn<Voiture, String> colModele;
    @FXML
    private TableColumn<Voiture, String> colCarte_grise;
    @FXML
    private TextField txtCarte_grise;
    @FXML
    private TextField txtModele;
    @FXML
    private TextField txtMatricule;
    @FXML
    private Button btnmod;
    @FXML
    private Button btnajout;
    @FXML
    private Button btngoto;
    @FXML
    private Button btnsup;
    
    ServiceVoiture sl= new ServiceVoiture();
    ObservableList<Voiture> ls = FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // initialisation des colonnes
        colId_voiture.setCellValueFactory(new PropertyValueFactory<Voiture, Integer>("id_voiture"));
        colMatricule.setCellValueFactory(new PropertyValueFactory<Voiture, String>("matricule"));
        colModele.setCellValueFactory(new PropertyValueFactory<Voiture, String>("modele"));
        colCarte_grise.setCellValueFactory(new PropertyValueFactory<Voiture, String>("carte_grise"));

  
        List<Voiture> voitureList = sl.afficher();
        ls.addAll(voitureList);
        tv.setItems(ls);

        // double click event handler pour remplir les text field bl selected row
        tv.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                Voiture v = tv.getSelectionModel().getSelectedItem();
                if (v != null) {
                    txtMatricule.setText(v.getMatricule());
                    txtModele.setText(v.getModele());
                    txtCarte_grise.setText(v.getCarte_grise());
                }
            }
        });
    }    

    @FXML
    private void modifierVoiture(ActionEvent event) {
        Voiture v = tv.getSelectionModel().getSelectedItem();
    if (v != null) {
        Integer id_voiture = v.getId_voiture();
        String matricule = txtMatricule.getText();
        String modele = txtModele.getText();
        String carte_grise = txtCarte_grise.getText();

       
        v.setMatricule(matricule);
        v.setModele(modele);
        v.setCarte_grise(carte_grise);

        // appel de la methode modifier de la base 
        sl.modifier(v);

        // table viue
        ls.set(tv.getSelectionModel().getSelectedIndex(), v);
    }
    }

    @FXML
    private void addVoiture(ActionEvent event) {
        if(txtMatricule.getText().isEmpty()||txtModele.getText().isEmpty()|| txtCarte_grise.getText().isEmpty()  )
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        }
          
        else if (!txtMatricule.getText().matches("\\d{3}TUN\\d{4}")) {
    JOptionPane.showMessageDialog(null, "Matricule should be in the format XXXTUNXXXX, where X is a number.");
        }
    else    
    {
        String matricule = txtMatricule.getText();
        String modele = txtModele.getText();
       String carte_grise = txtCarte_grise.getText();

        
         
        Voiture c = new Voiture(txtMatricule.getText(), txtModele.getText() , txtCarte_grise.getText());
        ServiceVoiture sc = new ServiceVoiture();
        sc.ajouter(c);
                    JOptionPane.showMessageDialog(null, "ajout avec succes");
        txtMatricule.clear();
        txtModele.clear();
        txtCarte_grise.clear();
 
    
  
        ls.addAll(sl.afficher());
         tv.setItems(ls);
       
       
         JOptionPane.showMessageDialog(null, "affichage avec succes");
     
         }
        
       }
    



    @FXML
    private void deleteVoiture(ActionEvent event) {
        Voiture selectedItem = tv.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Etes vous sure de supprimer cette element ?");   
        Optional<ButtonType> result = alert.showAndWait();
       if (result.get() == ButtonType.OK){
        ServiceVoiture ps = new ServiceVoiture(); 
        tv.getItems().remove(selectedItem);
        ps.supprimer(selectedItem);
       }
        }
        
    }
    
    @FXML
    private void to_Location(ActionEvent event) throws IOException {
        
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/projet/interfaces/VoitureInterface.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
