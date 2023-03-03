/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.service;

import projet.entities.Voiture;
import projet.entities.Location; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Projet.utils.MyConnection;

/**
 *
 * @author bahar
 */
public class ServiceLocation  implements Iservice<Location> {
      Connection cnx;
    PreparedStatement ste;
    
    public ServiceLocation(){
        this.cnx = MyConnection.getInstance().getConnection();
    }
    
    @Override
    public int ajouter(Location a) {
        int id=-1;
         try {
        String sql = "insert into location(id_location,date_debut,date_fin,prix_location,id_voiture)"+"values(NULL,?,?,?,?)";
        ste = cnx.prepareStatement(sql);
        ste.setString(1, a.getDate_debut());
        ste.setString(2, a.getDate_fin());
        ste.setInt(3, a.getPrix_location());
            ste.setInt(4, a.getId_voiture());
       
        ste.executeUpdate();
             System.out.println("Location confirmée!");
         }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    @Override
    public void supprimer(Location a) {
        
         String requete = "DELETE FROM location WHERE id_location= ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, a.getId_location());
            pst.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        System.out.println("Location supprimée!");
        }
    
    @Override
    public void modifier(Location a) {
        
        String req = "UPDATE location SET date_debut='"+a.getDate_debut()+"',date_fin='"+a.getDate_fin()+"',prix_location='"+a.getPrix_location()+"',id_voiture='"+a.getId_voiture()+"'WHERE id_location="+a.getId_location();
        try {
            PreparedStatement st1 = cnx.prepareStatement(req);
             
             st1.executeUpdate();
            System.out.println("Location modifié");

        } catch (SQLException ex) {
            System.out.println("Probleme");
            System.out.println(ex.getMessage());

        }
     }
    
    @Override
    public List<Location> afficher() {
      
        
        
          List<Location> list = new ArrayList<>();
      
    try {
        String requete = "SELECT * FROM location ORDER BY date_debut";
       PreparedStatement st1 = cnx.prepareStatement(requete);
        ResultSet rs = st1.executeQuery(requete);
        
        while (rs.next()) {
           Location a = new Location();
           a.setId_location(rs.getInt("id_location"));
            a.setDate_debut(rs.getString("date_debut"));
            a.setDate_fin(rs.getString("date_fin"));
            a.setPrix_location(rs.getInt("prix_location"));
            a.setId_voiture(rs.getInt("id_voiture"));
         
            System.out.println(a.getId_location());
            list.add(a);           
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
        return list;
      }
    
}
