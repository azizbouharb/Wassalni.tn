/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;
import PIClass.Chauffeur;
import PIServices.ServiceChauffeur;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Aziz Bouharb
 */
public class GestionController implements Initializable {
    @FXML
    private TableView<Chauffeur> tab;
    @FXML
    private Button supp;
    @FXML
    private TableColumn<Chauffeur, Integer> id;
    @FXML
    private TableColumn<Chauffeur, String> nom;
    @FXML
    private TableColumn<Chauffeur, String> img;
    @FXML
    private TableColumn<Chauffeur, String> mat;
    @FXML
    private TableColumn<Chauffeur, String> mail;
     @FXML
    private TableColumn<Chauffeur, String> pass;
      @FXML
    private TableColumn<Chauffeur, String> permis;
      private Stage primaryStage;
    private ObservableList<Chauffeur> RecData = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ContextMenu ContArticle = new ContextMenu();
        //Simple
        List<Chauffeur> listSimple= new ArrayList<Chauffeur>();
        ServiceChauffeur ss =  new ServiceChauffeur();
        listSimple = ss.getChauffeurById();
        RecData.clear();
        RecData.addAll(listSimple);
        tab.setItems(RecData);
        
        id.setCellValueFactory(
            new PropertyValueFactory<>("id_client")
        );
        nom.setCellValueFactory(
            new PropertyValueFactory<>("nom_client")
        );
        img.setCellValueFactory(
            new PropertyValueFactory<>("image_permis")
        );
        mat.setCellValueFactory(
            new PropertyValueFactory<>("id_voiture")
        );
        mail.setCellValueFactory(
            new PropertyValueFactory<>("email_client")
        );
        pass.setCellValueFactory(
            new PropertyValueFactory<>("pass_client")
        );
        permis.setCellValueFactory(
            new PropertyValueFactory<>("permis_chauf")
        );
        
        supp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                Object item = tab.getSelectionModel().getSelectedItem();
                Chauffeur art = (Chauffeur) item;
                ServiceChauffeur s = new ServiceChauffeur();
                System.out.println(art.toString()+"tess");
                s.supprimer(art);

                Afficher();

            }
        }
        );
        
    }    
    
    @FXML
    private void Afficher() {
        
         id.setCellValueFactory(
            new PropertyValueFactory<>("id_client")
        );
        nom.setCellValueFactory(
            new PropertyValueFactory<>("nom_client")
        );
        img.setCellValueFactory(
            new PropertyValueFactory<>("image_permis")
        );
        mat.setCellValueFactory(
            new PropertyValueFactory<>("id_voiture")
        );
        mail.setCellValueFactory(
            new PropertyValueFactory<>("email_client")
        );
        pass.setCellValueFactory(
            new PropertyValueFactory<>("pass_client")
        );
        permis.setCellValueFactory(
            new PropertyValueFactory<>("permis_chauf")
        );
        ServiceChauffeur srec = new ServiceChauffeur();
        RecData.removeAll();
        RecData.clear();
        
        srec.afficher().forEach(e -> {
            RecData.add(e);
        });
        tab.setItems(RecData);
    }
}
