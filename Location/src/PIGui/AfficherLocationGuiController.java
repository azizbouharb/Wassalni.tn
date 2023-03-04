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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
public class AfficherLocationGuiController implements Initializable {

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
    private Button Modifier;
    @FXML
    private Button GoToAjouter;
    @FXML
    private TableView<Location> tv1;
    @FXML
    private TableColumn<Location, Integer> colId_location;
    @FXML
    private TableColumn<Location, String> colDate1;
    @FXML
    private TableColumn<Location, String> colDate2;
    @FXML
    private TableColumn<Location, Integer> colPrix_location;
    @FXML
    private TableColumn<Location, String> colMatricule1;
    @FXML
    private TableColumn<Location, String> colModele1;
    @FXML
    private Button Supprimer;
    
    ServiceLocation sl= new ServiceLocation();
    ObservableList<Location> ls = FXCollections.observableArrayList();
    
    ServiceVoiture sl1= new ServiceVoiture();
    ObservableList<Voiture_location> ls1 = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /////////////// Voiture
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
        //////////////////////Location
        ls = FXCollections.observableArrayList();
    colId_location.setCellValueFactory(
            new PropertyValueFactory<Location, Integer>("id_location"));
    colDate1.setCellValueFactory(
            new PropertyValueFactory<Location, String>("date_debut"));
    colDate2.setCellValueFactory(
            new PropertyValueFactory<Location, String>("date_fin"));
    colPrix_location.setCellValueFactory(
            new PropertyValueFactory<Location, Integer>("prix_location"));
    colMatricule1.setCellValueFactory(
            new PropertyValueFactory<Location, String>("matricule"));
    colModele1.setCellValueFactory(
            new PropertyValueFactory<Location, String>("modele"));
    
    
  
   
    List<Location> l2 = sl.afficher();
    ls.addAll(l2);

    tv1.setItems(ls);
    
     tv1.setOnMouseClicked(e -> {
        if (e.getClickCount() == 2) {
            Location r = tv1.getSelectionModel().getSelectedItem();
            if (r != null) {
                PickerDate_debut.setValue(LocalDate.parse(r.getDate_debut()));
               PickerDate_fin.setValue(LocalDate.parse(r.getDate_fin()));
                 label_matricule.setText(r.getMatricule());
                    label_modele.setText(r.getModele());
                     label_prix.setText(String.valueOf(r.getPrix_location()));

            }
        }
    });
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
    private void GoToAjouter(ActionEvent event) throws IOException {
        
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/PIGui/LocationGui.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
      @FXML
    private void deleteLocation(ActionEvent event) {
        
         Location selectedItem = tv1.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Etes vous sure de supprimer cette element ?");   
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        ServiceLocation ps = new ServiceLocation(); 
        tv1.getItems().remove(selectedItem);
        ps.supprimer(selectedItem);
        }
        
        }
       
}
    
     @FXML
private void modifierLocation(ActionEvent event){
    LocalDate debut = PickerDate_debut.getValue();
    LocalDate fin = PickerDate_fin.getValue();
    Location r = tv1.getSelectionModel().getSelectedItem();
    Integer id_location = r.getId_location();
    Voiture_location v = tv.getSelectionModel().getSelectedItem();
    
    if (v!=null){
         Integer id_voiture = v.getId_voiture();
    Location c = new Location(id_location,debut.toString(), fin.toString(), id_voiture);
    ServiceLocation rm = new ServiceLocation();
    rm.modifier(c);
     JOptionPane.showMessageDialog(null, "modification effectué avec succès.");
    ArrayList<Location> publiciteList = (ArrayList<Location>) rm.afficher();
        ObservableList<Location> donnee = FXCollections.observableArrayList(publiciteList); 
        tv1.setItems(donnee);
    }else {
        Integer id_voiture = r.getId_voiture();
        Location c = new Location(id_location,debut.toString(), fin.toString(), id_voiture);
         ServiceLocation rm = new ServiceLocation();
    rm.modifier(c);
    JOptionPane.showMessageDialog(null, "modification effectué avec succès.");
    ArrayList<Location> publiciteList = (ArrayList<Location>) rm.afficher();
        ObservableList<Location> donnee = FXCollections.observableArrayList(publiciteList); 
        tv1.setItems(donnee);
        
    }
   
 

}
}
