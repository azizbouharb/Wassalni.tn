/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import projet.entities.Annonces;
import projet.service.ServiceAnnonce;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class DetailController implements Initializable {

    @FXML
    private AnchorPane brand;
    @FXML
    private ImageView image;
    private Label destination;
    @FXML
    private Button confirmer;
    @FXML
    private Button Retour;
    private VBox vboxx;
    @FXML
    private Label disponibilite;
    @FXML
    private Pane pane_m;
    @FXML
    private Button to_profile;
    @FXML
    private Button to_panier;
    @FXML
    private Button Alerts;
    @FXML
    private Label alerts;
    @FXML
    private Button Locaux;
    @FXML
    private Circle circle;
    @FXML
    private Button nom_u;
    @FXML
    private Button Accueil;
    @FXML
    private Button Reclamations;
    @FXML
    private Label ref;
    @FXML
    private Label desc;
    @FXML
    private Label nom;
    @FXML
    private Label depart;

    /**
     * Initializes the controller class.
     */
    private Annonces o;

    /*  public void setVBOXP() {
        int count = 0;
        int coun = 0;
        int cou = 0;
        HBox hbell = new HBox();

        ServiceAnnonce us = new ServiceAnnonce();
        List<Annonces> lu = null;
        lu = us.afficher();

        for (int i = 0; i < lu.size(); i++) {
            count++;
            coun++;
            cou++;

            VBox vbell1 = new VBox();
            Label nom = new Label();
            nom.setText(lu.get(i).getDestination_annonce());

            Label desc = new Label();
            desc.setText(lu.get(i).getDate_annonce());
            vbell1.setAlignment(Pos.CENTER);

            Label ref = new Label();
            ref.setText(String.valueOf(lu.get(i).getRef_annonce()));
            vbell1.setAlignment(Pos.CENTER);

            /*ImageView image = setImage(lu.get(i).getImage_name());
image.setFitHeight(60);
image.setFitWidth(60);
            vbell1.getChildren().addAll(nom, desc, ref);

            hbell.getChildren().add(vbell1);
            hbell.setMargin(vbell1, new Insets(50, 0, 0, 50));
//    hbell.getChildren().add(image);
            if ((count % 4) == 0) {
                vbell1.setAlignment(Pos.CENTER);

                vboxx.getChildren().add(hbell);
                hbell = new HBox();
            }

        }
        if ((coun % 3) == 0) {
            vboxx.getChildren().add(hbell);
            hbell = new HBox();
        }

        if ((cou % 1) == 0) {
            vboxx.getChildren().add(hbell);
            hbell = new HBox();
       }
 //   };*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //   setVBOXP();
        // TODO
    }

    public void initData(Annonces o) throws MalformedURLException {

        this.o = o;

        //   cl_mail.setText(o.getMailen());
        //Ref.setText(o.getId_annonce());
        //int id = o.getId_annonce();
        //Label ref = new Label();
             File file = new File ("C:\\Users\\maiss\\Documents\\NetBeansProjects\\Wassalni\\src\\image\\"+o.getImage_name());

        Image imageForFile = null;

        imageForFile = new Image(file.toURI().toURL().toExternalForm());

        ref.setText(Integer.toString(o.getId_annonce()));

        ref.setWrapText(true);

        nom.setText(o.getDestination_annonce());
        nom.setWrapText(true);
        desc.setText(o.getDate_annonce());
        depart.setText(o.getDepart_annonce());
        disponibilite.setText(Integer.toString(o.getDispo_annonce()));
        image.setImage(imageForFile);
    }

    @FXML
    private void ajouter(ActionEvent event) {
        
        
          
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Annonce Confirmee");
            tray.setMessage("succees");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        
        
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Affichage_Ann.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    private void Alerts(ActionEvent event) {
    }

    @FXML
    private void Locaux(ActionEvent event) {
    }

    @FXML
    private void To_Accueil(ActionEvent event) {
    }

    @FXML
    private void Reclamations(ActionEvent event) {
    }

}
