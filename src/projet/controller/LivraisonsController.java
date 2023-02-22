/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import entities.Livraison;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import services.LivraisonService;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static sun.net.www.MimeTable.loadTable;

/**
 * FXML Controller class
 *
 * @author farah
 */
public class LivraisonsController implements Initializable {

    @FXML
    private TableView<Livraison> tv_liraison;
    @FXML
    private TableColumn<Livraison, Integer> cin_c;
    @FXML
    private TableColumn<Livraison, String> depart_liv;
    @FXML
    private TableColumn<Livraison, String> destination_liv;
    @FXML
    private TableColumn<Livraison, String> image_prod;
    @FXML
    private TableColumn<Livraison, String> prix;
    @FXML
    private TableColumn<Livraison, String> date_liv;
    @FXML
    private TextField cinc_tf;
    @FXML
    private TextField image_tf;
    @FXML
    private Button btn_import;
    @FXML
    private TextField departliv_tf;
    @FXML
    private TextField destination_tf;
    @FXML
    private Button btn_ajout;
    @FXML
    private TextField prix_tf;
    @FXML
    private DatePicker dateliv_tf;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;
LivraisonService sl= new LivraisonService();
          List <Livraison> l2= new ArrayList<Livraison>();
           ObservableList <Livraison> ls;
    @FXML
    private Button pay;
    @FXML
    private Button Closeb;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          //final ObservableList<Livraison> data = FXCollections.observableArrayList(ls.get(i));
      ls = FXCollections.observableArrayList();
        cin_c.setCellValueFactory(
                new PropertyValueFactory<Livraison, Integer>("cin_client"));
        depart_liv.setCellValueFactory(
                new PropertyValueFactory<Livraison, String>("depart_liv"));
        destination_liv.setCellValueFactory(
                new PropertyValueFactory<Livraison, String>("dest_liv"));
        image_prod.setCellValueFactory(
                new PropertyValueFactory<Livraison, String>("image_pr"));
        prix.setCellValueFactory(
                new PropertyValueFactory<Livraison, String>("prix"));
        date_liv.setCellValueFactory(
                new PropertyValueFactory<Livraison, String>("date_liv"));
       
        System.out.println("aaa"+ls);
      //  tv_liraison.setItems(ls.get(i));
       tv_liraison.isEditable();
            //System.out.println(ls);
            
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
         if(cinc_tf.getText().isEmpty()||image_tf.getText().isEmpty()||departliv_tf.getText().isEmpty()||destination_tf.getText().isEmpty()||prix_tf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        }
        else {
        Livraison l= new Livraison(Integer.valueOf(cinc_tf.getText()),image_tf.getText(),departliv_tf.getText(),destination_tf.getText(),"15/01/20",Double.valueOf(prix_tf.getText()));
        LivraisonService sl= new LivraisonService();
       
        sl.ajouterLivraison(l);
        JOptionPane.showMessageDialog(null, " cher client veuillez attendre la confirmation du livreur");
        ls.addAll(sl.afficher());
         tv_liraison.setItems(ls);
         
         }  

    }

    @FXML
    private void delete(ActionEvent event) {
        Livraison selectedItem = tv_liraison.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Etes vous sure de supprimer cette element ?");   
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        LivraisonService ps = new LivraisonService(); 
        tv_liraison.getItems().remove(selectedItem);
        ps.supprimerLivraison(selectedItem);
        }
        
        }
        else {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un element à supprimer.");

        alert.showAndWait();
        }
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        
       //livraison cl=tv_liraison.getSelectionModel().getSelectedItem();
         
           
          
            
           
       // int cin_client = Integer.parseInt(cinc_tf.getText());
      //  String depart_liv =departliv_tf.getText();
       // String destination = destination_tf.getText();
      //  String image_pr = image_tf.getText();
      //  Double prix = Double.valueOf(prix_tf.getText());
        
        //    LivraisonService sc = new LivraisonService();
         //   Livraison e = new Livraison(cin_client,depart_liv,destination,"10/11/2023",image_pr,prix);
           //Cours cc = new Cours(id, instru , niveau, vid);
          //  sc.modifierLivraison(e);
            
          //  loadTable();
            
            
          //  double s = 1;
 
    //cin_c.setCellFactory(TextFieldTableCell.forTableColumn());
    //cin_c.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setCin_client(e.getNewValue()));

    //depart_liv.setCellFactory(TextFieldTableCell.forTableColumn());
    //depart_liv.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setImage_pr(e.getNewValue()));

   // prix.setCellFactory(TextFieldTableCell.forTableColumn());
    //prix.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrix((prix.getNewValue());

   // date_liv.setCellFactory(TextFieldTableCell.forTableColumn());
   // date_liv.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate_liv(e.getNewValue()));

    /* Allow for the values in each cell to be changable */
   //tv_liraison.setEditable(true); 
}

    @FXML
    private void to_payement(ActionEvent event) throws IOException {
        
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/gui/Payement.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
    }

    @FXML
    private void Close(ActionEvent event) {
        
         Stage window = (Stage) Closeb.getScene().getWindow();
        window.close();
        
        
    }
    }


    //@FXML
   // private void Statistiques(ActionEvent event) {
   // }

   // @FXML
    //private void accueilback(ActionEvent event) {
    //}
    
//}
