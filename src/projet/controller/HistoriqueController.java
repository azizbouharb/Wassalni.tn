/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import Projet.utils.MyConnection;
import animatefx.animation.BounceInDown;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import projet.entities.Annonces;

import projet.service.ServiceAnnonce;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class HistoriqueController implements Initializable {

    @FXML
    private AnchorPane brand;
    @FXML
    private ImageView emailCheckMark;
    @FXML
    private ImageView telCheckMark;
    @FXML
    private Pane pane_m;
    @FXML
    private Button to_profile;
    @FXML
    private Button to_panier;
    @FXML
    private Button Goto_Cov;
    @FXML
    private Button Alerts;
    @FXML
    private Label Goto_liv;
    @FXML
    private Button Evenements;
    @FXML
    private Label Goto_event;
    @FXML
    private Button Proposition;
    @FXML
    private Label Goto_location;
    @FXML
    private Circle circle;
    @FXML
    private Button nom_u;
    @FXML
    private Button to_menu;
    @FXML
    private Button Accueil;
    @FXML
    private TableColumn<Annonces, String> coldate;
    @FXML
    private TableColumn<Annonces, String> coldest;
    @FXML
    private TableColumn<Annonces, String> coldep;
    @FXML
    private TableColumn<Annonces, Integer> coldispo;
    @FXML
    private TableColumn<Annonces, Integer> colnum;
    @FXML
    private TableColumn<Annonces, String> colsupp;
    @FXML
    private TableView<Annonces> tv;
    private Button Supprimer;
    private Button Modifier;

    /**
     * Initializes the controller class.
     */
     String query = null;
     ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    @FXML
    private TableColumn<Annonces, Integer> colref;
    
   
    
    
    
    
      ObservableList<Annonces> data = FXCollections.observableArrayList();
    @FXML
    private FontAwesomeIconView refresh;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ServiceAnnonce ps = new ServiceAnnonce();
        ArrayList<Annonces> publiciteList = (ArrayList<Annonces>) ps.afficher_historique(0);
        ObservableList<Annonces> data = FXCollections.observableArrayList(publiciteList);
        tv.setItems(data);
        
       
        coldest.setCellValueFactory(new PropertyValueFactory<>("destination_annonce"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date_annonce"));
        coldispo.setCellValueFactory(new PropertyValueFactory<>("dispo_annonce"));
        colnum.setCellValueFactory(new PropertyValueFactory<>("Num_tel"));
        coldep.setCellValueFactory(new PropertyValueFactory<>("depart_annonce"));
        colref.setCellValueFactory(new PropertyValueFactory<>("id_annonce"));
        //add cell of button edit 
        Callback<TableColumn<Annonces, String>, TableCell<Annonces, String>> cellFoctory = (TableColumn<Annonces, String> param) -> {
            // make cell containing buttons
            final TableCell<Annonces, String> cell = new TableCell<Annonces, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {

                            Annonces selectedItem = tv.getSelectionModel().getSelectedItem();
                            if (selectedItem != null) {
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Confirmation Dialog");
                                alert.setContentText("Etes vous sure de supprimer cette element ?");
                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.get() == ButtonType.OK) {
                                    ServiceAnnonce Ann = new ServiceAnnonce();
                                    tv.getItems().remove(selectedItem);
                                    Ann.supprimer(selectedItem);
                                }

                            } else {

                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Information Dialog");
                                alert.setHeaderText(null);
                                alert.setContentText("Veuillez sélectionner un element à supprimer.");

                                alert.showAndWait();
                            }

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {

                              Annonces student = tv.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/interfaces/Modifierann.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(HistoriqueController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            ModifierAnnController addStudentController = loader.getController();
                            addStudentController.setUpdate(true);
                           addStudentController.setTextField(student.getId_annonce(),student.getDestination_annonce(),student.getDepart_annonce(), student.getDispo_annonce());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        colsupp.setCellFactory(cellFoctory);

    }

    @FXML
    private void load(ActionEvent event) {
    }

    @FXML
    private void To_Profile(ActionEvent event) {
    }

    @FXML
    private void To_Panier(ActionEvent event) {
    }

    @FXML
    private void Deconnexion(ActionEvent event) {
    }

    @FXML
    private void Reclamations(ActionEvent event) {
    }

    @FXML
    private void Alerts(ActionEvent event) {
    }

    @FXML
    private void Evenements(ActionEvent event) {
    }

    @FXML
    private void Proposition(ActionEvent event) {
    }

    @FXML
    private void ToMenu(ActionEvent event) {
    }

    @FXML
    private void To_Accueil(ActionEvent event) {
    }

    @FXML
private void Refresh(MouseEvent event) {
    // Clear the existing data in the table
    tv.getItems().clear();
    
    // Fetch the updated data from the database
    ServiceAnnonce ps = new ServiceAnnonce();
    ArrayList<Annonces> publiciteList = (ArrayList<Annonces>) ps.afficher_historique(0);
    data = FXCollections.observableArrayList(publiciteList);

    // Set the updated data to the table
    tv.setItems(data);
}


   
        
        
        
    }


