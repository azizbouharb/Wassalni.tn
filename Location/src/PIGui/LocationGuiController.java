/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;

import PIClass.Location;
import PIClass.Voiture_location;
import PIServices.ServiceLocation;
import PIServices.ServiceVoiture;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author bahar
 */
public class LocationGuiController implements Initializable {
    
         Connection cnx;
    PreparedStatement ste;

    @FXML
    private TableView<Voiture_location> tv;
    @FXML
    private TableColumn<Voiture_location, String> colModele;
    @FXML
    private TableColumn<Voiture_location, String> colMatricule;
    @FXML
    private TableColumn<Voiture_location, Integer> colPrix_jour;
    @FXML
    private TableColumn<Voiture_location, Integer> colId_voiture;
    @FXML
    private Button rechercher;
    @FXML
    private TextField txtRechercher;
    @FXML
    private Label label_modele;
    @FXML
    private Label label_matricule;
    @FXML
    private DatePicker PickerDate_debut;
    @FXML
    private DatePicker PickerDate_fin;
    @FXML
    private Label label_prix;
    @FXML
    private Label label_date1;
    @FXML
    private Label label_date2;
    @FXML
    private Button ajouter;
    @FXML
    private Button afficher;
    
    ServiceLocation sl= new ServiceLocation();
    ObservableList<Location> ls = FXCollections.observableArrayList();
    
    ServiceVoiture sl1= new ServiceVoiture();
    ObservableList<Voiture_location> ls1 = FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
        colMatricule.setCellValueFactory(new PropertyValueFactory<Voiture_location, String>("matricule"));
        colModele.setCellValueFactory(new PropertyValueFactory<Voiture_location, String>("modele"));
        colPrix_jour.setCellValueFactory(new PropertyValueFactory<Voiture_location, Integer>("prix_jour"));
        colId_voiture.setCellValueFactory(new PropertyValueFactory<Voiture_location, Integer>("id_voiture"));

  
        List<Voiture_location> voitureList = sl1.afficher();
        ls1.addAll(voitureList);
        tv.setItems(ls1);
        
        tv.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                Voiture_location v = tv.getSelectionModel().getSelectedItem();
                if (v != null) {
                    label_matricule.setText(v.getMatricule());
                    label_modele.setText(v.getModele());
                 
                }
            }
        });
        PickerDate_debut.valueProperty().addListener((observable, oldValue, newValue) -> {
        updatePriceLabel();
    });
         PickerDate_fin.valueProperty().addListener((observable, oldValue, newValue) -> {
        updatePriceLabel();
    });
        
        
        
        // TODO
    }
    private void updatePriceLabel() {
    LocalDate debut = PickerDate_debut.getValue();
    LocalDate fin = PickerDate_fin.getValue();
    
  
    if (debut != null && fin != null) {
        if (debut.isAfter(fin)) {
            label_date1.setText("La date de début doit être antérieure à la date de fin !");
            label_prix.setText("");
        } else {
            label_date1.setText("");
            long nbJours = ChronoUnit.DAYS.between(debut, fin);
            Voiture_location voiture = tv.getSelectionModel().getSelectedItem();
            if (voiture != null) {
                int prixJour = voiture.getPrix_jour();
                int prixTotal = prixJour * (int) nbJours;
                label_prix.setText(String.valueOf(prixTotal) + " DT");
            }
        }
    }
}

    
   @FXML
private void addLocation(ActionEvent event) {
    LocalDate debut = PickerDate_debut.getValue();
    LocalDate fin = PickerDate_fin.getValue();
    Voiture_location v = tv.getSelectionModel().getSelectedItem();
    Integer id_voiture = v.getId_voiture();

    if (debut == null || fin == null || v == null) {
        // Show an error message if any required field is not filled
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs obligatoires !");
        alert.showAndWait();
        return;
    }

    if (debut.isEqual(fin)) {
        // Show an error message if start date is the same as end date
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("La date de début ne peut pas être la même que la date de fin !");
        alert.showAndWait();
        return;
    }

    if (debut.isAfter(fin)) {
        // Show an error message if start date is after end date
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("La date de début doit être antérieure à la date de fin !");
        alert.showAndWait();
        return;
    }

    // Create a new Location object with the data from the UI
    Location c = new Location(debut.toString(), fin.toString(), id_voiture);
    ServiceLocation sc = new ServiceLocation();
    sc.ajouter(c);
    JOptionPane.showMessageDialog(null, "Ajout effectué avec succès.");
}



 @FXML
private void filter(ActionEvent event) {
    String searchValue = txtRechercher.getText().toLowerCase();
    ObservableList<Voiture_location> filteredList = FXCollections.observableArrayList();
    for (Voiture_location v : ls1) {
        if (v.getModele().toLowerCase().contains(searchValue)) {
            filteredList.add(v);
        }
    }
    tv.setItems(filteredList);
}

@FXML
    private void GoToAfficher(ActionEvent event) throws IOException {
        
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/PIGui/AfficherLocationGui.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }



    }
    
    




    

