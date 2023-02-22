/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.Chauffeur;
import PIUtils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class ServiceChauffeur implements Iservice<Chauffeur>{
    Connection cn = MyConnection.getTest().getCnx();

    @Override
    public int ajouter(Chauffeur t) {
     
         int id=1;
         try {
         
            System.out.println(t);
            String req = "INSERT INTO Chauffeurs VALUES  (null,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(req);
            pst.setInt(1, t.getCin_chauf());
            pst.setInt(2, t.getPermis_chauf());
            pst.setString(3, t.getImage_cin());

            pst.setInt(4, t.getId_voiture());

            pst.executeUpdate();
            System.out.println("Article ajouté !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    }
      return id;
    }

    @Override
    public void supprimer(Chauffeur t) {
         try {
            String req = "DELETE FROM Chauffeurs WHERE cin_chauf=?";
            PreparedStatement pst = cn.prepareStatement(req);
            pst.setInt(1, t.getCin_chauf());
            pst.executeUpdate();
            System.out.println("Article supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @Override
    public void modifier(Chauffeur t) {
  try {
            String req = "UPDATE chauffeurs SET cin_chauf=?,permis_chauf=?,image_permis=?,id_voiture=?  WHERE id_chauf=?";
            PreparedStatement pst = cn.prepareStatement(req);
          pst.setInt(1, t.getCin_chauf());
            pst.setInt(2, t.getPermis_chauf());
            pst.setString(3, t.getImage_cin());

            pst.setInt(4, t.getId_voiture());
            pst.setInt(5, t.getId_chauf());


            pst.executeUpdate();
            System.out.println("Chauffeur_id " + t.getId_chauf()+":" + " modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Chauffeur> afficher() {
           List<Chauffeur> list = new ArrayList<>();
      

        try {
            //String requete = "SELECT * FROM article";
            String requete="select * from chauffeurs";
            Statement st = cn.createStatement();
          
            ResultSet rs = st.executeQuery(requete);
           
            while (rs.next()) {
               while (rs.next()) {
               Chauffeur p = new Chauffeur();
               p.setId_chauf(rs.getInt("id_chauf"));
               p.setCin_chauf(rs.getInt("Cin_chauf"));
               p.setPermis_chauf(rs.getInt("Permis_chauf"));
               p.setImage_cin(rs.getString("Image_permis"));
               p.setId_voiture(rs.getInt("id_voiture"));

               System.out.println(p.getId_chauf());
               list.add(p);           
           }
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;

   
  
    

}
}
