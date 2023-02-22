/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Payement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;


/**
 *
 * @author farah
 */
public class PayementService implements IpayementService{
    
    Connection myconnex = MyConnection.getInstance().getConnection();
    Connection myconn = MyConnection.getInstance().getConnection();

    @Override
    public int ajouterLivraison(Payement p) {
       int id_payement=-1;
        try {
String sql = "INSERT INTO payement (nom_client, cin_cl, adresse, tel, type_carte ) VALUES (?, ?, ?, ?, ?)";
PreparedStatement pstmt = myconnex.prepareStatement(sql);


// définir les valeurs des paramètres
pstmt.setString(1, p.getNom_client());
pstmt.setInt(2, p.getCin_cl());
pstmt.setString(3, p.getAdresse());
pstmt.setInt(4, p.getTel());
pstmt.setString (5, p.getType_carte());

// exécuter la requête préparée
pstmt.executeUpdate();

// fermer la connexion
//myconnex.close();

           
          // Statement ste = myconnex.createStatement();
           //id_livraison= ste.executeUpdate(req1);
       } catch (SQLException ex) {
          System.out.println(ex);
       }
       return id_payement;
    }

    @Override
    public List<Payement> afficher() {
         List<Payement> list = new ArrayList<>();
      
    try {
        String requete = "SELECT * FROM payement";
       PreparedStatement pst = myconnex.prepareStatement(requete);
        ResultSet rs = pst.executeQuery(requete);
        
        while (rs.next()) {
           Payement p = new Payement(rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6));
          
            list.add(p);           
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
        return list;
       
    }
    }
        
        
    

   
    

