/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import Projet.utils.MyConnection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projet.entities.Annonces;
import projet.service.ServiceAnnonce;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class AnnoncesbackController implements Initializable {

    Connection cnx;
    PreparedStatement ste;
    
    
    
    @FXML
    private Label test;
    @FXML
    private TableView<?> commande;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> produit;
    //@FXML
    //private TableColumn<?, ?> client;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> quantite;
    @FXML
    private TableColumn<?, ?> prix;
    
    @FXML
    private TableView<Annonces> tv;
    @FXML
    private TableColumn<Annonces, String> coltype;
    @FXML
    private TableColumn<Annonces, String> coldescription;
    @FXML
    private TableColumn<Annonces, String> coldepart;
    @FXML
    private TableColumn<Annonces, Integer> coldispo;
    @FXML
    private TableColumn<Annonces, Integer> colnum;
    private DatePicker txtdate;
    private TextField txtdestination;
    private TextField txtdepart;
    private TextField txtdispo;
    private TextField txtnum;
    @FXML
    private TableColumn<?, ?> client;
   
   

    /**
     * Initializes the controller class.
     */
    
    
     
    
    
    ServiceAnnonce sl= new ServiceAnnonce();
          List <Annonces> l2= new ArrayList<Annonces>();
           ObservableList <Annonces> ls;
           ObservableList<Annonces> masterData = FXCollections.observableArrayList();
    @FXML
    private Button closeb;
    @FXML
    private Button Alert;
    @FXML
    private TextField Recherche_User;
    @FXML
    private ImageView myimageview;
    
      Image image=new Image("/image/wassalni-removebg-preview.png");
  
     public void displayImage() {
              myimageview.setImage(image);
            }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
   
      ls = FXCollections.observableArrayList();
        coltype.setCellValueFactory(new PropertyValueFactory<Annonces, String>("date_annonce"));
       coldescription.setCellValueFactory(
                new PropertyValueFactory<Annonces, String>("destination_annonce"));
        coldepart.setCellValueFactory(
                new PropertyValueFactory<Annonces, String>("depart_annonce"));
        coldispo.setCellValueFactory(
                new PropertyValueFactory<Annonces, Integer>("dispo_annonce"));
        
        colnum.setCellValueFactory(
                new PropertyValueFactory<Annonces, Integer>("Num_tel"));
   
        System.out.println("aaa"+ls);
      //  tv_liraison.setItems(ls.get(i));
     
       tv.setItems(ls);
      
       
      
        //for(int i = 0 ; i < tv.getItems().size() ; i++){
         //   System.out.println("person " + tv.getItems().get(i).getDestination_annonce());
       // }

       
       
       tv.isEditable();
     
            //System.out.println(ls);
    }
        
        
      
        
       

   

    private void deleteannonces(ActionEvent event) {
        
        // Annonces selectedItem = tv.getSelectionModel().getSelectedItem();
        //if(selectedItem!=null){
       //Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.setTitle("Confirmation Dialog");
        //alert.setContentText("Etes vous sure de supprimer cette element ?");   
       // Optional<ButtonType> result = alert.showAndWait();
       // if (result.get() == ButtonType.OK){
         
        
       
       Annonces selectedItem = tv.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Etes vous sure de supprimer cette element ?");   
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        ServiceAnnonce ps = new ServiceAnnonce() ; 
        tv.getItems().remove(selectedItem);
        ps.supprimer(selectedItem);
        }
        
        }
        else {
        
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un element à supprimer.");

        alert.showAndWait();
        }
       
       
       
       
    }
       
       
        
       // else {
        
        //Alert alert = new Alert(Alert.AlertType.WARNING);
      //  alert.setTitle("Information Dialog");
       // alert.setHeaderText(null);
        //alert.setContentText("Veuillez sélectionner un element à supprimer.");

       // alert.showAndWait();
       // }
        
        
        
        
    //}

    private void modifierannonces(ActionEvent event) {
       
       Annonces r=tv.getSelectionModel().getSelectedItem();
          String Date =r.getDestination_annonce();
          
        String Destination = txtdestination.getText();
         String Depart = txtdepart.getText();
         String Dispo = txtdispo.getText();
         String Num = txtnum.getText();  
         ServiceAnnonce rm = new ServiceAnnonce();
         Annonces r1 = new Annonces(Date, Destination ,  Depart, Integer.valueOf(Dispo) , Integer.valueOf(Num));
           
            rm.modifier(r1);
            ArrayList<Annonces> publiciteList =  (ArrayList<Annonces>) rm.afficher();
    ObservableList<Annonces> donnee = FXCollections.observableArrayList(publiciteList); 
       tv.setItems(donnee);
        //colid.setCellValueFactory(new PropertyValueFactory<>("id"));
         coltype.setCellValueFactory(new PropertyValueFactory<Annonces, String>("date_annonce"));
       coldescription.setCellValueFactory(new PropertyValueFactory<Annonces, String>("destination_annonce"));
        coldepart.setCellValueFactory(new PropertyValueFactory<Annonces, String>("depart_annonce"));
        coldispo.setCellValueFactory(new PropertyValueFactory<Annonces, Integer>("dispo_annonce"));
        
        colnum.setCellValueFactory(new PropertyValueFactory<Annonces, Integer>("Num_tel"));
        
        
        
                                 JOptionPane.showMessageDialog(null, "modifier avec succes");
      
      
      
      
      
      
    }

    private void addannonce(ActionEvent event) {
        
          if(txtdestination.getText().isEmpty()||txtdepart.getText().isEmpty() ||txtdispo.getText().isEmpty()||txtnum.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        }
          
        else
        {
        Date datee=java.sql.Date.valueOf(txtdate.getValue());
        String Destination  = txtdestination.getText();
        String Depart = txtdepart.getText();
        String Dispo = txtdispo.getText();
        String Num = txtnum.getText();
        
         
        Annonces c = new Annonces("20-05-2022", txtdestination.getText() ,  txtdepart.getText(), Integer.valueOf(txtdispo.getText()) , Integer.valueOf(txtnum.getText()));
        ServiceAnnonce sc = new ServiceAnnonce();
        sc.ajouter(c);
                    JOptionPane.showMessageDialog(null, "ajout avec succes");
        
        txtdestination.clear();
        txtdepart.clear();
        txtdispo.clear();
        txtnum.clear();
        
        
        
        
           
        ls.addAll(sl.afficher());
         tv.setItems(ls);
           JOptionPane.showMessageDialog(null, "Affichage avec succes");
       
       FilteredList<Annonces> filteredData = new FilteredList<>(ls, b -> true);

        Recherche_User.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(an -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (an.getDestination_annonce().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (an.getDepart_annonce().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                 else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<Annonces> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tv.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tv.setItems(sortedData);
    }
        
         }
        
        
        
        
        
    

    
    
    
    @FXML
    private void Close(ActionEvent event) {
              Stage window = (Stage) closeb.getScene().getWindow();
        window.close();
    }

    

    @FXML
    private void to_Allert(ActionEvent event) throws IOException {
        
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/AlertsGUI.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    private void stat(ActionEvent event) throws IOException {
        
        
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Statann.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
    
    
   /*  public  ObservableList<Annonces> getUserList() {
         cnx = MyConnection.getInstance().getConnection();
        
        ObservableList<Annonces> UserList = FXCollections.observableArrayList();
        try {
                String query2="SELECT * FROM  annonce WHERE destination_annonce= ?";
                PreparedStatement smt = cnx.prepareStatement(query2);
               
                
                Annonces a;
                ResultSet rs= smt.executeQuery();
            while(rs.next()){
                a=new Annonces(txtdate.getText(), txtdestination.getText() ,  txtdepart.getText(), Integer.valueOf(txtdispo.getText()) , Integer.valueOf(txtnum.getText()));
                UserList.add(a);
            }
                System.out.println(UserList);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return UserList;
   
    }
    
    */
    
    
    
    
    
    

  /* private void searchRec(KeyEvent ke) {
        
       /*  coltype.setCellValueFactory(new PropertyValueFactory<>("date_annonce"));
       coldescription.setCellValueFactory(new PropertyValueFactory<>("destination_annonce"));
        coldepart.setCellValueFactory(new PropertyValueFactory<>("depart_annonce"));
        coldispo.setCellValueFactory(new PropertyValueFactory<>("dispo_annonce"));
        
        colnum.setCellValueFactory(new PropertyValueFactory<>("Num_tel"));
         
         ObservableList<Annonces> list = getUserList();
        tv.setItems(list);
         FilteredList<Annonces> filteredData = new FilteredList<>(list,b->true);
         Recherche_User.textProperty().addListener((observable,oldValue,newValue)-> {
             filteredData.setPredicate(rec-> {
                 if (newValue == null || newValue.isEmpty()){
                     return true;
                 }
                 String lowerCaseFilter = newValue.toLowerCase();
                 if (rec.getDestination_annonce().toLowerCase().indexOf(lowerCaseFilter)!= -1){
                 return true;
                 }
                 else
                 return false ;
                 
             });
         });
         SortedList<Annonces> sortedData = new SortedList<>(filteredData);
         sortedData.comparatorProperty().bind(tv.comparatorProperty());
         tv.setItems(sortedData);
         */
        
       
      
            
      
    

    



       
       
       
    

    
    
    
    
    
    
    
    
    
    
    
    

