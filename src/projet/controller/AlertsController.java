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
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.Date;
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
    import javafx.scene.control.Button;
    import javafx.scene.control.ComboBox;
    import javafx.scene.control.DatePicker;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextArea;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.AnchorPane;
    import javafx.scene.layout.Pane;
    import javafx.stage.Stage;
    import javax.swing.JOptionPane;
    import projet.entities.Alerts;
    import projet.entities.Annonces;
    import projet.service.AlertsService;
    import projet.service.ServiceAnnonce;

    /**
     * FXML Controller class
     *
     * @author Maissa
     */
    public class AlertsController implements Initializable {
    Connection cnx;
        PreparedStatement ste;
        ServiceAnnonce ann= new ServiceAnnonce();
        ObservableList<Annonces> ann1=FXCollections.observableArrayList();

        @FXML
        private AnchorPane brand;
        private TextField localisation;
        @FXML
        private TextField mail;
        @FXML
        private TextArea rapport;
        @FXML
        private Button envoyeralert;
        private TextField telephone;
        @FXML
        private Pane pane_m;
        @FXML
        private Button to_profile;
        @FXML
        private Button to_panier;
        @FXML
        private Label Annonces;
        @FXML
        private Button Annonce;
        @FXML
        private Button Locaux;
        @FXML
        private Button to_menu;
        @FXML
        private Label Propositions;
        @FXML
        private Button Accueil;
        @FXML
        private Button Alert;
        @FXML
        private ComboBox<Integer> ComboId_annonce;
    @FXML
    private Label txtDestination;
    @FXML
    private Label txtTelephone;
    @FXML
    private Label txtDate;


        /**
         * Initializes the controller class.
         */

@Override
public void initialize(URL url, ResourceBundle rb) {
    // Get the list of annonces from the ServiceAnnonce object
    ann1.addAll(ann.getAll());

    // Create a list of integers from the id_annonce values
    List<Integer> idAnnonces = new ArrayList<>();
    for (Annonces a : ann1) {
        idAnnonces.add(a.getId_annonce());
    }

    // Set the items property of the ComboId_annonce ComboBox with the list of integers
    ComboId_annonce.setItems(FXCollections.observableArrayList(idAnnonces));

    // Add a listener to the ComboId_annonce ComboBox that listens for changes to the selected item
    ComboId_annonce.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
        if (newVal != null) {
            // Retrieve the corresponding Annonces object from the ann1 observable list using the selected id_annonce value
            Annonces selectedAnnonce = null;
            for (Annonces a : ann1) {
                if (a.getId_annonce() == newVal) {
                    selectedAnnonce = a;
                    break;
                }
            }

            // Set the values of the txtDestination, txtDate, and txtTelephone fields to the values retrieved from the selected Annonces object
            txtDestination.setText(selectedAnnonce.getDestination_annonce());
            txtDate.setText(selectedAnnonce.getDate_annonce().toString());
            txtTelephone.setText(Integer.toString(selectedAnnonce.getNum_tel()));
        }
    });
}






        @FXML
private void envoyeralert(ActionEvent event) {

    
        int id_annonce = ComboId_annonce.getValue();
        String rapport_text = rapport.getText();
        String mail_text = mail.getText();

        Alerts alert = new Alerts(id_annonce, rapport_text, mail_text);
        AlertsService alertsService = new AlertsService();
        alertsService.ajouter(alert);

        JOptionPane.showMessageDialog(null, "Alerte envoyée avec succès !");
    }














        @FXML
        private void to_alert(ActionEvent event) throws IOException {

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/interfaces/AlertsGUI.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();




        }

    }
