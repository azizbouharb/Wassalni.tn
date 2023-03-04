/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.Voiture_location;
import PIClass.Location; 
import PIServices.Iservice;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import PIUtils.MyConnection;
import PIUtils.MyConnection;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author bahar
 */
public class ServiceLocation implements Iservice<Location>{
    Connection cnx;
    PreparedStatement ste;
    
     public ServiceLocation(){
        this.cnx = MyConnection.getInstance().getConnection();
    }
     
     

@Override
public void modifier(Location a) {
    try {
        // Get the daily price of the car and calculate the rental price
        int prix_jour = 0;
        int numberOfDays = 0;
        String query = "SELECT prix_jour FROM voiture_location WHERE id_voiture = ?";
        PreparedStatement pstmt = cnx.prepareStatement(query);
        pstmt.setInt(1, a.getId_voiture());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            prix_jour = rs.getInt("prix_jour");
        }
        LocalDate debut = LocalDate.parse(a.getDate_debut());
        LocalDate fin = LocalDate.parse(a.getDate_fin());
        numberOfDays = (int) ChronoUnit.DAYS.between(debut, fin);
        int prix_location = prix_jour * numberOfDays;

        // Update the rental data in the "location" table
        String req = "UPDATE location "
                   + "INNER JOIN voiture_location ON location.id_voiture = voiture_location.id_voiture "
                   + "SET location.date_debut = '"+a.getDate_debut()+"', "
                   + "location.date_fin = '"+a.getDate_fin()+"', "
                   + "location.prix_location = '"+prix_location+"', "
                   + "location.id_voiture = '"+a.getId_voiture()+"', "
                   + "location.matricule = voiture_location.matricule, "
                   + "location.modele = voiture_location.modele "
                   + "WHERE location.id_location = "+a.getId_location();
        PreparedStatement st1 = cnx.prepareStatement(req);
        st1.executeUpdate();
        System.out.println("Location modifié");
    } catch (SQLException ex) {
        System.out.println("Probleme");
        System.out.println(ex.getMessage());
    }
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
             a.setMatricule(rs.getString("matricule"));
              a.setModele(rs.getString("modele"));
         
            System.out.println(a.getId_location());
            list.add(a);           
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
        return list;
      }
    
    public int ajouter(Location rental) {
    int rentalId = 0;

    try {
        String query = "SELECT prix_jour FROM voiture_location WHERE id_voiture = ?";
        PreparedStatement pstmt = cnx.prepareStatement(query);
        pstmt.setInt(1, rental.getId_voiture());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            int dailyPrice = rs.getInt("prix_jour");

            LocalDate start = LocalDate.parse(rental.getDate_debut());
            LocalDate end = LocalDate.parse(rental.getDate_fin());
            int rentalDays = (int) ChronoUnit.DAYS.between(start, end);
            int rentalPrice = dailyPrice * rentalDays;

            String insertQuery = "INSERT INTO location (date_debut, date_fin, prix_location, id_voiture, matricule, modele) "
                    + "SELECT ?, ?, ?, id_voiture, matricule, modele FROM voiture_location WHERE id_voiture = ?";
            pstmt = cnx.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, rental.getDate_debut());
            pstmt.setString(2, rental.getDate_fin());
            pstmt.setInt(3, rentalPrice);
            pstmt.setInt(4, rental.getId_voiture());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                rentalId = generatedKeys.getInt(1);
                System.out.println("Rental added successfully. ID: " + rentalId);
            }
        } else {
            System.out.println("Could not retrieve daily price for car " + rental.getId_voiture());
        }
    } catch (SQLException ex) {
        System.out.println("Error adding rental.");
        System.out.println(ex.getMessage());
    }

    return rentalId;
}

    
    


}
