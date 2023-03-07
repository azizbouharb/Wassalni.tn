/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controller;

import Projet.utils.MyConnection;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import projet.service.ServiceAnnonce;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import projet.entities.Annonces;
import Projet.utils.MyConnection;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author hocin
 */
public class ModifierAnnController implements Initializable {

    @FXML
    private JFXTextField nameFld;
    @FXML
    private DatePicker birthFld;
    @FXML
    private JFXTextField adressFld;
    @FXML
    private JFXTextField emailFld;

    String query = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Annonces student = null;
    private boolean update;
    int studentId;
    @FXML
    private JFXTextField Ref;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void save(MouseEvent event) {

        Connection cnx = MyConnection.getInstance().getConnection();
        String Destination = nameFld.getText();
         String Date = String.valueOf(birthFld.getValue());
       
        String Depart = adressFld.getText();
        int Dispo = Integer.parseInt(emailFld.getText());
        int ref = Integer.parseInt(Ref.getText());

        if (Destination.isEmpty() || Depart.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            Annonces a = new Annonces(ref, Date.toString(), Destination, Depart, Dispo);
        
        // call the modifier method to update the record in the database
        ServiceAnnonce sa = new ServiceAnnonce();
        sa.modifier(a);
        
        // show success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Annonce updated successfully");
        alert.showAndWait();
        
        // clear the text fields
        clean();

    }
        

        }

    
    

    @FXML
    private void clean() {
        nameFld.setText(null);
        birthFld.setValue(null);
        adressFld.setText(null);
        emailFld.setText(null);

    }

    

    private void insert() {

        try {
        Connection cnx = MyConnection.getInstance().getConnection();

            preparedStatement = cnx.prepareStatement(query);
            int ref = Integer.parseInt(Ref.getText());
preparedStatement.setInt(1, ref);

            preparedStatement.setString(2, nameFld.getText());
           
            preparedStatement.setString(3, adressFld.getText());
            
            int email = Integer.parseInt(emailFld.getText());
preparedStatement.setInt(4, email);
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ModifierAnnController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void setTextField(int Id_annonce,String destination_annonce, String depart_annonce,int dispo_annonce) {

       Ref.setText(String.valueOf(Id_annonce));
        nameFld.setText(destination_annonce);
       // emailFld.setText(dispo_annonce);
        
        adressFld.setText(depart_annonce);
          emailFld.setText(String.valueOf(dispo_annonce));

    }

    void setUpdate(boolean b) {
        this.update = b;

    }

}
