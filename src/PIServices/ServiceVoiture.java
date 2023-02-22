/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;


import PIClass.Voiture;
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
 * @author Aziz Bouharb
 */
public class ServiceVoiture implements Iservice<Voiture>{
    Connection cn = MyConnection.getTest().getCnx();

    public int ajouter(Voiture t) {
     
         int id=1;
         try {
         
            System.out.println(t);
            String req = "INSERT INTO Voiture VALUES  (null,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(req);
            pst.setString(1, t.getMatricule());
            pst.setString(2, t.getCarte_grise());
            pst.setString(3, t.getModele());

           

            pst.executeUpdate();
            System.out.println("Article ajouté !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    }
      return id;
    }


    public void supprimer(Voiture t) {
         try {
            String req = "DELETE FROM Voiture WHERE matricule=?";
            PreparedStatement pst = cn.prepareStatement(req);
            pst.setString(1, t.getMatricule());
            pst.executeUpdate();
            System.out.println("Article supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

   
    public void modifier(Voiture t) {
  try {
            String req = "UPDATE voiture SET matricule=?,carte_grise=?,modele=?  WHERE id_voiture=?";
            PreparedStatement pst = cn.prepareStatement(req);
          pst.setString(1, t.getMatricule());
            pst.setString(2, t.getCarte_grise());
            pst.setString(3, t.getModele());

            pst.setInt(4, t.getId_voiture());
          


            pst.executeUpdate();
            System.out.println("id_Voiture " + t.getId_voiture()+":" + " modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

   
    public List<Voiture> afficher() {
           List<Voiture> list = new ArrayList<>();
      

        try {
            //String requete = "SELECT * FROM article";
            String requete="select * from Voiture";
            Statement st = cn.createStatement();
          
            ResultSet rs = st.executeQuery(requete);
           
            while (rs.next()) {
               while (rs.next()) {
               Voiture p = new Voiture();
               p.setId_voiture(rs.getInt("id_voiture"));
               p.setCarte_grise(rs.getString("Carte_grise"));
               p.setMatricule(rs.getString("matricule"));
               p.setModele(rs.getString("modele"));
             

               System.out.println(p.getId_voiture());
               list.add(p);           
           }
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;

   
  
    

}
}
