/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.service;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Projet.utils.MyConnection;


import java.sql.Date;
import projet.entities.Alerts;

/**
 *
 * @author Taher
 */
public class AlertsService implements Iservice<Alerts>{
       Connection cnx;
          PreparedStatement ste;

       public AlertsService() {
         this.cnx = MyConnection.getInstance().getConnection();
    }
       
    
   /* public void ajouteAlerts(Alerts c){
         try {
        String sql = "insert into alerts(programme_id,localisation,date,rapport,telephone,mail)"+"values(?,?,?,?,?,?)";
        ste = cnx.prepareStatement(sql);
        ste.setInt(1, c.getProgramme_id());
        ste.setString(2, c.getLocalisation());
        ste.setDate(3,(Date) c.getDate());
        ste.setString(4, c.getRapport());
        ste.setInt(5, c.getTelephone());
        ste.setString(6, c.getMail());
        ste.executeUpdate();
             System.out.println("Alert ajoutée!");
         }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    
    /*public void modifierAlerts(Alerts a){
        String req = "UPDATE alerts SET programme_id='"+a.getProgramme_id()+"',localisation='"+a.getLocalisation()+"',date='"+a.getDate()+"',rapport="+a.getRapport()+", telephonne="+a.getTelephone()+", mail='"+a.getMail()+"' WHERE id="+a.getId() ;
        try {
            PreparedStatement st1 = cnx.prepareStatement(req);
             
             st1.executeUpdate();
            System.out.println("Alerts modifié");

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());

        }

    }*/
    
   /*public void supprimerAlerts(Alerts c){
        String requete = "DELETE FROM alerts WHERE id = ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        System.out.println("Alerts supprimée!");
    }*/
    
    /* public List<Alerts> afficherAlerts(){
        List<Alerts> list = new ArrayList<>();
        String requete = "SELECT * FROM alerts ";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                Alerts a = new Alerts(rs.getInt("id"),rs.getString("localisation"),rs.getDate("date"),rs.getString("rapport"),rs.getInt("telephone"),rs.getString("mail"));                
                list.add(a);
            }
            System.out.println("List des alerts à été crée!");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return list;
    }*/

    @Override
    public int ajouter(Alerts a) {
        int id=1;
         try {
        String sql = "insert into alerts(id,programme_id,destination,date,rapport,Num_tel,mail)"+"values(NULL,?,?,?,?,?,?)";
        ste = cnx.prepareStatement(sql);
        ste.setInt(1, a.getProgramme_id());
        ste.setString(2, a.getDestination());
        ste.setString(3,a.getDate());
        ste.setString(4, a.getRapport());
        ste.setInt(5, a.getNum_tel());
        ste.setString(6, a.getMail());
        ste.executeUpdate();
             System.out.println("Alert ajoutée!");
         }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return id;
    }

    @Override
    public void supprimer(Alerts a) {
       String requete = "DELETE FROM alerts WHERE destination = ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, a.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        System.out.println("Alerts supprimée!");
    }
    
    
    @Override
    public void modifier(Alerts a) {
       
         String req = "UPDATE alerts SET programme_id='"+a.getProgramme_id()+"',destination='"+a.getDestination()+"',date='"+a.getDate()+"',rapport="+a.getRapport()+", Num_tel="+a.getNum_tel()+", mail='"+a.getMail()+"' WHERE id="+a.getId() ;
        try {
            PreparedStatement st1 = cnx.prepareStatement(req);
             
             st1.executeUpdate();
            System.out.println("Alerts modifié");

        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());

        }
        
        
        
        
    }

    @Override
    public List<Alerts> afficher() {
         
          List<Alerts> list = new ArrayList<>();
      
    try {
        String requete = "SELECT * FROM alerts ORDER BY destination";
       PreparedStatement st1 = cnx.prepareStatement(requete);
        ResultSet rs = st1.executeQuery(requete);
        
        while (rs.next()) {
           Alerts a = new Alerts();
             a.setId(rs.getInt("id"));
            a.setProgramme_id(rs.getInt("programme_id"));
            a.setDestination(rs.getString("destination"));
            a.setDate(rs.getString("date"));
            a.setRapport(rs.getString("rapport"));
            a.setNum_tel(rs.getInt("Num_tel"));
             a.setMail(rs.getString("mail"));
            System.out.println(a.getId());
            list.add(a);           
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
        return list;
       
     
    
}




}