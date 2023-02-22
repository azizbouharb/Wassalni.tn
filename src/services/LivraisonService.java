/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Livraison;
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
 * @author dell
 */
public class LivraisonService implements IlivraisonService{
   
    Connection myconnex = MyConnection.getInstance().getConnection();
    Connection myconn = MyConnection.getInstance().getConnection();
            
//    MyConnection myconnex =new MyConnection();
    
    public int getNextRef() {
    int ref = 0;
    try {
        // Retrieve the highest "ref" value from the "livraisons" table
        String sql = "SELECT MAX(ref) FROM livraisons";
        Statement stmt = myconnex.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            ref = rs.getInt(1);
        }
        ref++; // increment the value by 1
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    return ref;
}
    
    
    
    
    @Override
    public int ajouterLivraison(Livraison l) {
     int id_livraison=-1;
        try {
          ///String req1 ="INSERT INTO `livraisons`( `id_client`, `id_chauf`, `depart`, `dest`, `image_pr`, `etat_liv`, `prix`, `date_liv`) VALUES (' " +l.getId_client()+ " ' ,' " +l.getId_chauf()+ " ', ' " +l.getDepart()+ " ',' " +l.getDest()+ " ',' " +l.getImage_pr()+ " ',' " +l.getEtat_liv()+ " ',' " +l.getPrix()+" ',' " +l.getDate_liv()+ " ');+;
                   
                //   + " VALUES (NULL, '"+p.getNom()+" ', '"
                //   + p.getAge()+"'); ";
                
    // établir une connexion à la base de données

int ref = getNextRef();
// construire la requête préparée
String sql = "INSERT INTO livraisons (cin_client,  depart_liv, dest_liv, image_pr, prix, date_liv, etat_liv, ref) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
PreparedStatement pstmt = myconnex.prepareStatement(sql);


// définir les valeurs des paramètres
pstmt.setInt(1, l.getCin_client());
pstmt.setString(2, l.getDepart_liv());
pstmt.setString(3, l.getDest_liv());
pstmt.setString(4, l.getImage_pr());
pstmt.setDouble(5, l.getPrix());
pstmt.setString(6, l. getDate_liv());
pstmt.setString(7, "en cours");
pstmt.setInt(8, ref );

// exécuter la requête préparée
pstmt.executeUpdate();

// fermer la connexion
//myconnex.close();

           
          // Statement ste = myconnex.createStatement();
           //id_livraison= ste.executeUpdate(req1);
       } catch (SQLException ex) {
          System.out.println(ex);
       }
       return id_livraison;
    }

    @Override
    public boolean modifierLivraison(Livraison l) {
    try {
        String req = "UPDATE livraisons SET cin_client=?, cin_livreur=?, depart_liv=?, dest_liv=?, image_pr=?, prix=?, date_liv=?, etat_liv=? WHERE ref=?";
        PreparedStatement pst = myconnex.prepareStatement(req);
        pst.setInt(1, l.getCin_client());
        pst.setInt(2, l.getCin_livreur());
        pst.setString(3, l.getDepart_liv());
        pst.setString(4, l.getDest_liv());
        pst.setString(5, l.getImage_pr());
        pst.setDouble(6, l.getPrix());
        pst.setString(7, l.getDate_liv()); 
        pst.setString(8, l.getEtat_liv());
        pst.setInt(9, l.getRef());
      
        
      
        

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("ref " + l.getRef()+":" + " modifié !");
            return true;
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return false;
}


   
    @Override
    public boolean supprimerLivraison(Livraison l) {
         try {
            String req = "DELETE FROM livraisons WHERE cin_client=?";
            PreparedStatement pst = myconnex.prepareStatement(req);
            pst.setInt(1, l.getCin_client());
            pst.executeUpdate();
            System.out.println("Article supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         return false;
    }

  

    @Override
    public List<Livraison> afficher() {
         List<Livraison> list = new ArrayList<>();
      
    try {
        String requete = "SELECT * FROM livraisons ";
       PreparedStatement pst = myconnex.prepareStatement(requete);
        ResultSet rs = pst.executeQuery(requete);
        
        while (rs.next()) {
           Livraison l = new Livraison(rs.getInt(2),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8));
          
            list.add(l);           
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
        return list;
       
    }
    
}

