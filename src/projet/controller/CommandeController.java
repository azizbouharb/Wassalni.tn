/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import entities.Payement;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.PayementService;

/**
 * FXML Controller class
 *
 * @author farah
 */
public class CommandeController implements Initializable {
@FXML
    private TableView<Payement> tv;
    @FXML
    private TableColumn<Payement, String> c1;
    @FXML
    private TableColumn<Payement, Integer> c2;
    @FXML
    private TableColumn<Payement, String> c3;
    @FXML
    private TableColumn<Payement, Integer> c4;
    @FXML
    private TableColumn<Payement, String> c5;
    @FXML
   
    private Pane fpane;
    @FXML
    private VBox vbox1;
    @FXML
    private Label article1;
    @FXML
    private Pane form1;
    @FXML
    private Button payer;
    @FXML
    private Label e_nom;
    @FXML
    private TextField nom;
    @FXML
    private TextField cin;
    @FXML
    private Label e_mail;
    @FXML
    private TextField adresse;
    @FXML
    private Label e_telephone;
    @FXML
    private Label e_prenom;
    @FXML
    private TextField carte;
    @FXML
    private TextField type;
    @FXML
    private Pane pane_m;
    @FXML
    private Button to_profile;
    @FXML
    private Button to_panier;
    @FXML
    private Button Programmes;
    @FXML
    private Button Locaux;
    @FXML
    private Button Proposition;
    @FXML
    private Label Propositions;
    @FXML
    private Button to_menu;
    @FXML
    private Button Accueil;
    @FXML
    private Label alerts;

    /**
     * Initializes the controller class.
     */
    
    PayementService sl= new PayementService();
          List <Payement> l2= new ArrayList<Payement>();
           ObservableList <Payement> ls;
    @FXML
    private Button Closeb;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              ls = FXCollections.observableArrayList();
        c1.setCellValueFactory(
                new PropertyValueFactory<Payement, String>("nom_client"));
        c2.setCellValueFactory(
                new PropertyValueFactory<Payement, Integer>("cin_cl"));
       c3.setCellValueFactory(
                new PropertyValueFactory<Payement, String>("adresse"));
        c4.setCellValueFactory(
                new PropertyValueFactory<Payement, Integer>("tel"));
        c5.setCellValueFactory(
                new PropertyValueFactory<Payement, String>("type_carte"));
        
       
        System.out.println("aaa"+ls);
      //  tv_liraison.setItems(ls.get(i));
       tv.isEditable();
        
        
        
        
    }    

    @FXML
    private void PayerALivraison(ActionEvent event) {
        
         if(nom.getText().isEmpty()||cin.getText().isEmpty()||adresse.getText().isEmpty()||carte.getText().isEmpty()||type.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        }
        else {
        Payement l= new Payement (nom.getText(),Integer.valueOf(cin.getText()),adresse.getText(),Integer.valueOf(carte.getText()),type.getText());
        PayementService sl= new PayementService();
       
        sl.ajouterLivraison(l);
        
        ls.addAll(sl.afficher());
         tv.setItems(ls);
         
         }  
        
        
        
        
        
        
        
    }

    @FXML
    private void Close(ActionEvent event) {
        
        
         Stage window = (Stage) Closeb.getScene().getWindow();
        window.close();
        
        
    }
    
}
