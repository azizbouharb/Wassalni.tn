/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.service;

import projet.entities.Annonces; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Projet.utils.MyConnection;

/**
 *
 * @author ASUS
 */
public class ServiceAnnonce   implements Iservice<Annonces> {
    Connection cnx;
    PreparedStatement ste;
    
    public ServiceAnnonce(){
        this.cnx = MyConnection.getInstance().getConnection();
    }
    

    
    public int getNextRef() {
    int ref = 0;
    try {
        // Retrieve the highest "ref" value from the "livraisons" table
        String sql = "SELECT MAX(rRef_annonce) FROM annonce";
       ste = cnx.prepareStatement(sql);
        ResultSet rs = ste.executeQuery(sql);
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
    public int ajouter(Annonces a) {
        int id=-1;
         try {
        String sql = "insert into annonce(id_annonce,date_annonce,destination_annonce,depart_annonce,dispo_annonce,Num_tel,Ref_annonce,id_chauff,Image_name)"+"values(NULL,?,?,?,?,?,?,?,?)";
        ste = cnx.prepareStatement(sql);
        ste.setString(1, a.getDate_annonce());
        ste.setString(2, a.getDestination_annonce());
        ste.setString(3, a.getDepart_annonce());
        ste.setInt(4, a.getDispo_annonce());
        ste.setInt(5, a.getNum_tel());
        ste.setInt(6, a.getRef_annonce());
        ste.setInt(7, a.getId_chauff());
         ste.setString(8, a.getImage_name());
        ste.executeUpdate();
             System.out.println("Annonce ajoutée!");
         }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    @Override
    public void supprimer(Annonces a) {
        
         String requete = "DELETE FROM annonce WHERE destination_annonce= ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, a.getDestination_annonce());
            pst.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        System.out.println("Réclamations supprimée!");
        
        
        
    }

    @Override
    public void modifier(Annonces a) {
        
        String req = "UPDATE annonce SET date_annonce='"+a.getDate_annonce()+"',destination_annonce='"+a.getDestination_annonce()+"',depart_annonce='"+a.getDepart_annonce()+"',dispo_annonce='"+a.getDispo_annonce()+"'WHERE id_annonce="+a.getId_annonce();
        try {
            PreparedStatement st1 = cnx.prepareStatement(req);
             
             st1.executeUpdate();
            System.out.println("Reclamation modifié");

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());

        }
        
        
        
        
        
    }

  
   
      

    @Override
public List<Annonces> afficher() {
    List<Annonces> list = new ArrayList<>();
    try {
        String requete = "SELECT * FROM annonce ORDER BY destination_annonce";
        PreparedStatement st1 = cnx.prepareStatement(requete);
        ResultSet rs = st1.executeQuery(requete);

        while (rs.next()) {
            Annonces a = new Annonces();
            a.setDate_annonce(rs.getString("date_annonce"));
            a.setDestination_annonce(rs.getString("destination_annonce"));
            a.setDepart_annonce(rs.getString("depart_annonce"));
            a.setDispo_annonce(rs.getInt("dispo_annonce"));
            a.setNum_tel(rs.getInt("Num_tel"));
            a.setRef_annonce(rs.getInt("Ref_annonce"));
            a.setId_annonce(rs.getInt("id_annonce"));
             a.setImage_name(rs.getString("Image_name"));
            list.add(a);
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return list;
}


    public List<Annonces> afficher_historique(int id_chauff) {
    List<Annonces> list = new ArrayList<>();
    try {
        String requete = "SELECT * FROM annonce WHERE id_chauff = ?";
        PreparedStatement st1 = cnx.prepareStatement(requete);
        st1.setInt(1, id_chauff);
        ResultSet rs = st1.executeQuery();
        while (rs.next()) {
            Annonces a = new Annonces();
            a.setDate_annonce(rs.getString("date_annonce"));
            a.setDestination_annonce(rs.getString("destination_annonce"));
            a.setDepart_annonce(rs.getString("depart_annonce"));
            a.setDispo_annonce(rs.getInt("dispo_annonce"));
            a.setNum_tel(rs.getInt("Num_tel"));
            a.setId_annonce(rs.getInt("id_annonce"));
            list.add(a);
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return list;
}

public List<Annonces> getAll() {
    List<Annonces> list = new ArrayList<>();
    try {
        String requete = "SELECT * FROM annonce";
        PreparedStatement st1 = cnx.prepareStatement(requete);
        ResultSet rs = st1.executeQuery(requete);

        while (rs.next()) {
            Annonces a = new Annonces();
            a.setDate_annonce(rs.getString("date_annonce"));
            a.setDestination_annonce(rs.getString("destination_annonce"));
            a.setDepart_annonce(rs.getString("depart_annonce"));
            a.setDispo_annonce(rs.getInt("dispo_annonce"));
            a.setNum_tel(rs.getInt("Num_tel"));
            a.setRef_annonce(rs.getInt("Ref_annonce"));
            a.setId_annonce(rs.getInt("id_annonce"));
            list.add(a);
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return list;
}

   

        
   
    

}
