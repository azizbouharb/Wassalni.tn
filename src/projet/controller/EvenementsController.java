/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author farah
 */
public class EvenementsController implements Initializable {

    @FXML
    private TableView<?> tv_evenement;
    @FXML
    private TableColumn<?, ?> cl_dated;
    @FXML
    private TableColumn<?, ?> cl_image;
    @FXML
    private TableColumn<?, ?> cl_nbrp;
    @FXML
    private TableColumn<?, ?> cl_datef;
    @FXML
    private TableColumn<?, ?> cl_lieu;
    @FXML
    private TableColumn<?, ?> cl_desc;
    @FXML
    private TableColumn<?, ?> cl_id;
    @FXML
    private TableColumn<?, ?> cl_nom;
    @FXML
    private TableColumn<?, ?> cl_nom1;
    @FXML
    private DatePicker tf_datefin;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_image;
    @FXML
    private Button btn_import;
    @FXML
    private TextField txtRech;
    @FXML
    private TextField tf_desc;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button Statistiques;
    @FXML
    private Button closeb;
    @FXML
    private Circle circle;
    @FXML
    private Button nom_u;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleMouseButton(MouseEvent event) {
    }

    @FXML
    private void importer(ActionEvent event) {
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void Statistiques(ActionEvent event) {
    }

    @FXML
    private void accueilback(ActionEvent event) {
    }

    @FXML
    private void ToUtilisateur(ActionEvent event) {
    }

    @FXML
    private void To_Activite(ActionEvent event) {
    }

    @FXML
    private void To_Convention(ActionEvent event) {
    }

    @FXML
    private void To_ProduitM(ActionEvent event) {
    }

    @FXML
    private void To_Transport(ActionEvent event) {
    }

    @FXML
    private void To_Fonctionnalite(ActionEvent event) {
    }

    @FXML
    private void Close(ActionEvent event) {
    }

    @FXML
    private void To_ProfileB(ActionEvent event) {
    }

    @FXML
    private void To_Programme(ActionEvent event) {
    }

    @FXML
    private void To_Evenement(ActionEvent event) {
    }

    @FXML
    private void To_Locaux(ActionEvent event) {
    }

    @FXML
    private void To_Publicite(ActionEvent event) {
    }

    @FXML
    private void To_Sponsor(ActionEvent event) {
    }

    @FXML
    private void To_Transporteur(ActionEvent event) {
    }

    @FXML
    private void To_Livreur(ActionEvent event) {
    }

    @FXML
    private void To_Produit(ActionEvent event) {
    }

    @FXML
    private void To_Categorie(ActionEvent event) {
    }

    @FXML
    private void To_Commande(ActionEvent event) {
    }

    @FXML
    private void To_livraison(ActionEvent event) {
    }

    @FXML
    private void To_Reclamation(ActionEvent event) {
    }

    @FXML
    private void To_Alert(ActionEvent event) {
    }

    @FXML
    private void To_Proposevent(ActionEvent event) {
    }
    
}
