/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.service;
import projet.entities.Voiture; 
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
public class ServiceVoiture  implements Iservice<Voiture>{
    Connection cnx;
    PreparedStatement ste;
    
    public ServiceVoiture(){
        this.cnx = MyConnection.getInstance().getConnection();
    }
    
    @Override
    public int ajouter(Voiture a) {
        int id=-1;
         try {
        String sql = "insert into voiture(id_voiture,matricule,modele,carte_grise)"+"values(NULL,?,?,?)";
        ste = cnx.prepareStatement(sql);
        ste.setString(1, a.getMatricule());
        ste.setString(2, a.getModele());
        ste.setString(3, a.getCarte_grise());
       
        ste.executeUpdate();
             System.out.println("Voiture ajoutée!");
         }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    @Override
    public void supprimer(Voiture a) {
        
         String requete = "DELETE FROM voiture WHERE matricule= ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, a.getMatricule());
            pst.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        System.out.println("Voiture supprimée!");
        }
    
    
    @Override
    public void modifier(Voiture a) {
        
        String req = "UPDATE voiture SET matricule='"+a.getMatricule()+"',modele='"+a.getModele()+"',carte_grise='"+a.getCarte_grise()+"'WHERE id_voiture="+a.getId_voiture();
        try {
            PreparedStatement st1 = cnx.prepareStatement(req);
             
             st1.executeUpdate();
            System.out.println("Voiture modifié");

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());

        }
     }
    
    @Override
    public List<Voiture> afficher() {
      
        
        
          List<Voiture> list = new ArrayList<>();
      
    try {
        String requete = "SELECT * FROM voiture ORDER BY modele";
       PreparedStatement st1 = cnx.prepareStatement(requete);
        ResultSet rs = st1.executeQuery(requete);
        
        while (rs.next()) {
           Voiture a = new Voiture();
           a.setId_voiture(rs.getInt("id_voiture"));
            a.setMatricule(rs.getString("matricule"));
            a.setModele(rs.getString("modele"));
            a.setCarte_grise(rs.getString("carte_grise"));
         
            System.out.println(a.getId_voiture());
            list.add(a);           
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
        return list;
      }
    
    
    
}
