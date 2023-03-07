/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import Projet.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import projet.service.ServiceAnnonce;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class StatannController implements Initializable {

    @FXML
    private PieChart piechart;
    
     ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
     Connection cnx = MyConnection.getInstance().getConnection(); 

   
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            stat();
        } catch (SQLException ex) {
            Logger.getLogger(StatannController.class.getName()).log(Level.SEVERE, null, ex);
        }
         piechart.setData(data);
        
    }    
    
    
     private void stat() throws SQLException
    {
          data = FXCollections.observableArrayList();
        String requete = "SELECT destination_annonce, dispo_annonce FROM annonce group by destination_annonce";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
           data.add(new PieChart.Data(rs.getString("destination_annonce"), rs.getInt("dispo_annonce")));
    
    }
    
    }
    

    @FXML
    private void retour(ActionEvent event) throws IOException {
       
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Annonceback.fxml")); /* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
