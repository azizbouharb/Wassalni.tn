/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.Location;
import PIClass.Voiture_location;
import PIUtils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bahar
 */
public class ServiceVoiture implements Iservice<Voiture_location> {
      Connection cnx;
    PreparedStatement ste;
    
     public ServiceVoiture(){
        this.cnx = MyConnection.getInstance().getConnection();
    }
     
     @Override
    public List<Voiture_location> afficher() {
      
        
        
          List<Voiture_location> list = new ArrayList<>();
      
    try {
        String requete = "SELECT * FROM voiture_location ORDER BY modele";
       PreparedStatement st1 = cnx.prepareStatement(requete);
        ResultSet rs = st1.executeQuery(requete);
        
        while (rs.next()) {
           Voiture_location a = new Voiture_location();
           
           a.setId_voiture(rs.getInt("id_voiture"));
            a.setMatricule(rs.getString("matricule"));
            a.setModele(rs.getString("modele"));

            a.setPrix_jour(rs.getInt("prix_jour"));
         
         
            System.out.println(a.getId_voiture());
            list.add(a);           
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
        return list;
      }

    @Override
    public int ajouter(Voiture_location a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Voiture_location a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Voiture_location a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   public Voiture_location rechercher(String modele) {
    Voiture_location voiture = null;
    try {
        String requete = "SELECT * FROM voiture_location WHERE modele LIKE ?";
        PreparedStatement st1 = cnx.prepareStatement(requete);
        st1.setString(1, "%" + modele + "%");
        ResultSet rs = st1.executeQuery();

        if (rs.next()) {
            voiture = new Voiture_location();
            voiture.setId_voiture(rs.getInt("id_voiture"));
            voiture.setMatricule(rs.getString("matricule"));
            voiture.setModele(rs.getString("modele"));
            voiture.setCarte_grise(rs.getString("carte_grise"));
            voiture.setPrix_jour(rs.getInt("prix_jour"));
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return voiture;
}


    
    
    
}
