/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import animatefx.animation.SlideInDown;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import projet.controller.AnnonceFXMLController;
import projet.controller.AlertsGUIController;
import projet.entities.Annonces;
import projet.entities.Alerts;

import projet.service.ServiceAnnonce;

/**
 * FXML Controller class
 *
 * @author Taher
 */
public class Affichage_AnnController implements Initializable {

    @FXML
    private AnchorPane brand;

    @FXML
    private TextField Searchp;
    @FXML
    private VBox vboxx;
    @FXML
    private VBox affich_produit;
    private ServiceAnnonce cp = new ServiceAnnonce();
    private Annonces o;

    List<Annonces> liste = new ArrayList<Annonces>();
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
    private Button Evenements;
    @FXML
    private Circle circle;
    @FXML
    private Button nom_u;
    @FXML
    private Button to_menu;
    @FXML
    private Button Accueil;

/*    public void setVBOXP() {
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
            ref.setText(String.valueOf(lu.get(i).getId_annonce()));
            vbell1.setAlignment(Pos.CENTER);

            ImageView image = setImage(lu.get(i).getImage_name());
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
    }*/

    public void initialize(URL url, ResourceBundle rb) {

        //Font.loadFont(getClass().getResourceAsStream("/css/SourceSansPro-Regular.ttf"), 14);
      //  setVBOXP();
        HBox item = new HBox();
        affich_produit.getChildren().add(item);
        liste = cp.afficher();

        int taille = liste.size();
        for (int i = 0; i < taille; i++) {

            if (i % 4 == 0) {
                item = new HBox();
                affich_produit.getChildren().add(item);
            }
            VBox content = new VBox();

            Label title = new Label();
            o = liste.get(i);

            Image image = null;
            try {
                image = new Image(new FileInputStream("C:\\Users\\maiss\\Documents\\NetBeansProjects\\Wassalni\\src\\image\\" + liste.get(i).getImage_name()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Affichage_AnnController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(150);
            imageView.setFitWidth(200);

            Label description = new Label((liste.get(i).getDate_annonce()));
            description.setStyle("-fx-strikethrough: true");
            description.getStyleClass().add("barre");

            Label reference = new Label(String.valueOf(liste.get(i).getId_annonce()));

            description.setStyle("-fx-strikethrough: true");
            description.getStyleClass().add("barre");

            Label prixpromo = new Label(liste.get(i).getDestination_annonce());
            prixpromo.setStyle("-fx-font-weight: bold");

            content.getChildren().addAll(imageView, title, prixpromo, description, reference);
            Button btn = new Button("", content);
            Annonces o1 = new Annonces(o.getDate_annonce(), o.getDepart_annonce(), o.getDestination_annonce(), o.getDispo_annonce(), o.getNum_tel(), o.getId_annonce(), o.getImage_name());

            btn.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/DetailController.fxml"));

                    Scene scene = new Scene(loader.load());

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    stage.setScene(scene);

                    stage.show();
                    DetailController controller = loader.<DetailController>getController();

                    controller.initData(o1);
                } catch (IOException ex) {
                    Logger.getLogger(Affichage_AnnController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            btn.setPrefWidth(200);
            item.getChildren().add(btn);
            affich_produit.setSpacing(50);
            item.setSpacing(20);
        }

    }

    private void Categories(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/accueilFGUI.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void Alerts(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/AlertsFGUI.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void campi(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/CategoriesGUI.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ToMenu(ActionEvent event) {
        if (!(pane_m.isVisible())) {
            new SlideInDown(pane_m).play();
            pane_m.setVisible(true);
        } else {
            pane_m.setVisible(false);
        }
    }

    @FXML
    private void Deconnexion(ActionEvent event) {

    }

    private void Reclamations(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/reclamationfront.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Programmes(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/AnnonceFront.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Locaux(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/LocauxFront.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Evenements(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/front.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void Proposition(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/propositionfront.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void To_Panier(ActionEvent event) {

    }

    @FXML
    private void To_Profile(ActionEvent event) {

    }

    @FXML
    private void To_Accueil(ActionEvent event) {

    }

}
