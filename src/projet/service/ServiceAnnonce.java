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
    

    @Override
    public int ajouter(Annonces a) {
        int id=-1;
         try {
        String sql = "insert into annonce(id_annonce,date_annonce,destination_annonce,depart_annonce,dispo_annonce,Num_tel)"+"values(NULL,?,?,?,?,?)";
        ste = cnx.prepareStatement(sql);
        ste.setString(1, a.getDate_annonce());
        ste.setString(2, a.getDestination_annonce());
        ste.setString(3, a.getDepart_annonce());
        ste.setInt(4, a.getDispo_annonce());
        ste.setInt(5, a.getNum_tel());
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
        
        String req = "UPDATE annonce SET date_annonce='"+a.getDate_annonce()+"',destination_annonce='"+a.getDestination_annonce()+"',depart_annonce='"+a.getDepart_annonce()+"',dispo_annonce='"+a.getDispo_annonce()+"',Num_tel='"+a.getNum_tel()+"'WHERE id="+a.getId_annonce();
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
            System.out.println(a.getId_annonce());
            list.add(a);           
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
        return list;
       
        
        
        
  
    }
        
   
    

}
