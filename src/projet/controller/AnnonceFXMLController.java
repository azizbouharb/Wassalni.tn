/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import projet.entities.Alerts;
import projet.entities.Annonces;
import projet.service.AlertsService;
import projet.service.ServiceAnnonce;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class AnnonceFXMLController implements Initializable {

    @FXML
    private TextField txtdepart;
    @FXML
    private TextField txtdestination;
    @FXML
    private DatePicker txtdate;
    @FXML
    private TextField txtdispo;
    @FXML
    private Button envoyer;
    @FXML
    private TextField txtnum;
    private Button closeb;
    @FXML
    private ImageView myimageview;

    /**
     * Initializes the controller class.
     */
    // Image monImage = new Image(getClass().getResourceAsStream("/image/Wassalni-removebg-preview.png"));
    Image image = new Image("/image/wassalni-removebg-preview.png");
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
    private Button btnhistorique;

    public void displayImage() {
        myimageview.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceAnnonce sc = new ServiceAnnonce();
        List<Annonces> l2 = new ArrayList<Annonces>();
        ObservableList<Alerts> ls;
        // TODO
    }

    @FXML
    private void envoyerannonce(ActionEvent event) {

        if (txtdepart.getText().isEmpty() || txtdestination.getText().isEmpty() || txtdispo.getText().isEmpty() || txtnum.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "verifer les champs");
        } else if (txtdepart.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "verifer les champs");

        } else if (txtdestination.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "verifer les champs");

        } else {
            String depart = txtdepart.getText();
            int Num = Integer.parseInt(txtnum.getText());
            String Destination = txtdestination.getText();
            Date Date = java.sql.Date.valueOf(txtdate.getValue());
            String Disponibilite = txtdispo.getText();
            String image = "téléchargement.jpg";
            Annonces a = new Annonces("15-20-2020", txtdestination.getText(), txtdepart.getText(), Integer.valueOf(txtdispo.getText()), Integer.valueOf(txtnum.getText()), 0,image);

            ServiceAnnonce sc = new ServiceAnnonce();
            sc.ajouter(a);
            JOptionPane.showMessageDialog(null, "ajout avec succes");

            txtdepart.clear();
            txtdestination.clear();
            txtdispo.clear();
            txtnum.clear();


            /*  Notifications notificationBuilder =Notifications.create()
          .title("L'annonce a ete ajoute")
          .text("")
           .graphic(null)
           .hideAfter(Duration.minutes(3))   
           .position(Pos.TOP_CENTER)     
           .onAction(new EventHandler<ActionEvent>(){
       @Override
        public void handle(ActionEvent event){
            System.out.println("clicked on notification");
        }
    });
  //notificationBuilder.darkStyle();
notificationBuilder.showConfirm();
             */
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Annonce ajoutee avec succees");
            tray.setMessage("succees");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));

        }

    }

    private void close(ActionEvent event) {

        Stage window = (Stage) closeb.getScene().getWindow();
        window.close();
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
    private void Historique(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Historique.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
